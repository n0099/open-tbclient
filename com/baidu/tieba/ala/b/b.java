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
    private static int fcR;
    private CommonEmptyView faG;
    private BdGridView fcS;
    private a fcT;
    private List<g> fcU;
    private g fcV;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        fcR = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bnu() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        this.fcS = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.fcS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.fcV = (g) b.this.fcU.get(i);
                b.this.fdg = b.this.fcV.vU();
                b.this.fcT.zS(b.this.fdg);
            }
        });
        this.faG = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void e(TextView textView) {
        textView.setText(a.i.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        d(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void ay(int i, String str) {
        Yl();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fcV != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.fcV.vV());
                jSONObject.put("gift_url", this.fcV.vX());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.fcV.vU());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.fde.setResult(-1, intent);
        }
        this.fde.finish();
    }

    private void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.zf())) {
            showNoDataView();
            return;
        }
        this.fcS.setVisibility(0);
        this.faG.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.v.a.En().aRB.avL.axu;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.v.a.En().aRB.avL.axt;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.v.a.En().aRB.avL.axv : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.zf().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.fcU = next.wv();
                break;
            }
        }
        if (ListUtils.isEmpty(this.fcU)) {
            showNoDataView();
        } else {
            bnw();
        }
    }

    private void Yl() {
        aqE();
    }

    private void showNoDataView() {
        aqE();
    }

    private void aqE() {
        this.fcS.setVisibility(8);
        this.faG.setVisibility(0);
        this.faG.reset();
        this.faG.setTitle(a.i.sdk_net_fail_tip_rank);
        this.faG.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.faG.setVisibility(8);
                b.this.bw(b.this.faG);
            }
        });
        this.faG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.faG.setVisibility(0);
    }

    private void bnw() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.fcU) {
            if (gVar != null && gVar.vU() != null) {
                if (gVar.vU().equals(this.fdg)) {
                    this.fcV = gVar;
                }
                if (!ListUtils.isEmpty(this.eHn) && this.eHn.contains(gVar.vU())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.fcU.removeAll(arrayList);
        }
        this.fcT = new a(this.fde.getPageContext());
        this.fcS.setAdapter((ListAdapter) this.fcT);
        this.fcT.zR(this.fdg);
        this.fcT.setData(this.fcU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String eHm;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void zR(String str) {
            this.eHm = str;
        }

        public void zS(String str) {
            if (this.eHm == null || !this.eHm.equals(str)) {
                this.eHm = str;
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
        /* renamed from: bL */
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
            C0482b c0482b;
            if (view == null) {
                C0482b c0482b2 = new C0482b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.fcR;
                layoutParams.height = b.fcR;
                view.setLayoutParams(layoutParams);
                c0482b2.fcX = (FrameLayout) view.findViewById(a.g.item_root);
                c0482b2.fcY = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0482b2.fcY.setDefaultBgResource(a.f.icon_live_gift_default);
                c0482b2.fcY.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0482b2.fcY.setAutoChangeStyle(false);
                c0482b2.fcZ = (TextView) view.findViewById(a.g.item_gift_title);
                c0482b2.aBI = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0482b2);
                c0482b = c0482b2;
            } else {
                c0482b = (C0482b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0482b.fcY.startLoad(item.vX(), 10, false);
                c0482b.fcZ.setText(item.vV());
                a(c0482b.aBI, item.getPrice());
                if (item.vU().equals(this.eHm)) {
                    c0482b.fcX.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0482b.fcX.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.v.a.En().aQu.asV) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0482b {
        public TextView aBI;
        public FrameLayout fcX;
        public TbImageView fcY;
        public TextView fcZ;

        private C0482b() {
        }
    }
}
