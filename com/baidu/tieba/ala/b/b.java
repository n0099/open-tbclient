package com.baidu.tieba.ala.b;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.AlaChooseGiftActivity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d {
    private static int fqF;
    private CommonEmptyView aYj;
    private BdGridView fqG;
    private a fqH;
    private List<g> fqI;
    private g fqJ;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        fqF = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bto() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        this.fqG = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.fqG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.fqJ = (g) b.this.fqI.get(i);
                b.this.fqU = b.this.fqJ.xl();
                b.this.fqH.Bz(b.this.fqU);
            }
        });
        this.aYj = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void e(TextView textView) {
        textView.setText(a.i.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void aD(int i, String str) {
        abh();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fqJ != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.fqJ.xm());
                jSONObject.put("gift_url", this.fqJ.xo());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.fqJ.xl());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.fqS.setResult(-1, intent);
        }
        this.fqS.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.At())) {
            showNoDataView();
            return;
        }
        this.fqG.setVisibility(0);
        this.aYj.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.v.a.Ge().aYP.aAT.aCK;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.v.a.Ge().aYP.aAT.aCJ;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.v.a.Ge().aYP.aAT.aCL : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.At().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.fqI = next.xM();
                break;
            }
        }
        if (ListUtils.isEmpty(this.fqI)) {
            showNoDataView();
        } else {
            btq();
        }
    }

    private void abh() {
        bqU();
    }

    private void showNoDataView() {
        bqU();
    }

    private void bqU() {
        this.fqG.setVisibility(8);
        this.aYj.setVisibility(0);
        this.aYj.reset();
        this.aYj.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aYj.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aYj.setVisibility(8);
                b.this.bv(b.this.aYj);
            }
        });
        this.aYj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.aYj.setVisibility(0);
    }

    private void btq() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.fqI) {
            if (gVar != null && gVar.xl() != null) {
                if (gVar.xl().equals(this.fqU)) {
                    this.fqJ = gVar;
                }
                if (!ListUtils.isEmpty(this.eTV) && this.eTV.contains(gVar.xl())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.fqI.removeAll(arrayList);
        }
        this.fqH = new a(this.fqS.getPageContext());
        this.fqG.setAdapter((ListAdapter) this.fqH);
        this.fqH.By(this.fqU);
        this.fqH.setData(this.fqI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String eTU;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void By(String str) {
            this.eTU = str;
        }

        public void Bz(String str) {
            if (this.eTU == null || !this.eTU.equals(str)) {
                this.eTU = str;
                notifyDataSetChanged();
            }
        }

        public void setData(List<g> list) {
            this.dataList = new ArrayList(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dataList == null) {
                return 0;
            }
            return this.dataList.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: bU */
        public g getItem(int i) {
            if (this.dataList == null) {
                return null;
            }
            return this.dataList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0529b c0529b;
            if (view == null) {
                C0529b c0529b2 = new C0529b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.fqF;
                layoutParams.height = b.fqF;
                view.setLayoutParams(layoutParams);
                c0529b2.fqL = (FrameLayout) view.findViewById(a.g.item_root);
                c0529b2.fqM = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0529b2.fqM.setDefaultBgResource(a.f.icon_live_gift_default);
                c0529b2.fqM.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0529b2.fqM.setAutoChangeStyle(false);
                c0529b2.fqN = (TextView) view.findViewById(a.g.item_gift_title);
                c0529b2.aHf = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0529b2);
                c0529b = c0529b2;
            } else {
                c0529b = (C0529b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0529b.fqM.startLoad(item.xo(), 10, false);
                c0529b.fqN.setText(item.xm());
                a(c0529b.aHf, item.getPrice());
                if (item.xl().equals(this.eTU)) {
                    c0529b.fqL.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0529b.fqL.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.v.a.Ge().aWF.axV) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0529b {
        public TextView aHf;
        public FrameLayout fqL;
        public TbImageView fqM;
        public TextView fqN;

        private C0529b() {
        }
    }
}
