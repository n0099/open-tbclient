package com.baidu.tieba.ala.a;

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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.AlaChooseGiftActivity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d {
    private static int etw;
    private CommonEmptyView erG;
    private g etA;
    private BdGridView etx;
    private a ety;
    private List<g> etz;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        etw = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.a.d
    protected int getLayoutResId() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.a.d
    protected void initView() {
        this.etx = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.etx.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.a.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.etA = (g) b.this.etz.get(i);
                b.this.etL = b.this.etA.qE();
                b.this.ety.xL(b.this.etL);
            }
        });
        this.erG = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void d(TextView textView) {
        textView.setText(a.i.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        d(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void ai(int i, String str) {
        Oe();
    }

    @Override // com.baidu.tieba.ala.a.d
    public void confirm() {
        if (this.etA != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.etA.qF());
                jSONObject.put("gift_url", this.etA.qH());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.etA.qE());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.etJ.setResult(-1, intent);
        }
        this.etJ.finish();
    }

    private void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.tp())) {
            showNoDataView();
            return;
        }
        this.etx.setVisibility(0);
        this.erG.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.s.a.wR().atk.abg.acM;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.s.a.wR().atk.abg.acL;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.s.a.wR().atk.abg.acN : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.tp().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.etz = next.qX();
                break;
            }
        }
        if (ListUtils.isEmpty(this.etz)) {
            showNoDataView();
        } else {
            bbL();
        }
    }

    private void Oe() {
        age();
    }

    private void showNoDataView() {
        age();
    }

    private void age() {
        this.etx.setVisibility(8);
        this.erG.setVisibility(0);
        this.erG.reset();
        this.erG.setTitle(a.i.sdk_net_fail_tip_rank);
        this.erG.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.erG.setVisibility(8);
                b.this.bt(b.this.erG);
            }
        });
        this.erG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.erG.setVisibility(0);
    }

    private void bbL() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.etz) {
            if (gVar != null && gVar.qE() != null) {
                if (gVar.qE().equals(this.etL)) {
                    this.etA = gVar;
                }
                if (!ListUtils.isEmpty(this.ecL) && this.ecL.contains(gVar.qE())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.etz.removeAll(arrayList);
        }
        this.ety = new a(this.etJ.getPageContext());
        this.etx.setAdapter((ListAdapter) this.ety);
        this.ety.xK(this.etL);
        this.ety.setData(this.etz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String ecK;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void xK(String str) {
            this.ecK = str;
        }

        public void xL(String str) {
            if (this.ecK == null || !this.ecK.equals(str)) {
                this.ecK = str;
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
        /* renamed from: br */
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
            C0410b c0410b;
            if (view == null) {
                C0410b c0410b2 = new C0410b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.etw;
                layoutParams.height = b.etw;
                view.setLayoutParams(layoutParams);
                c0410b2.etC = (FrameLayout) view.findViewById(a.g.item_root);
                c0410b2.etD = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0410b2.etD.setDefaultBgResource(a.f.icon_live_gift_default);
                c0410b2.etD.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0410b2.etD.setAutoChangeStyle(false);
                c0410b2.etE = (TextView) view.findViewById(a.g.item_gift_title);
                c0410b2.agQ = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0410b2);
                c0410b = c0410b2;
            } else {
                c0410b = (C0410b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0410b.etD.startLoad(item.qH(), 10, false);
                c0410b.etE.setText(item.qF());
                a(c0410b.agQ, item.getPrice());
                if (item.qE().equals(this.ecK)) {
                    c0410b.etC.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0410b.etC.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.s.a.wR().asq.Yy) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0410b {
        public TextView agQ;
        public FrameLayout etC;
        public TbImageView etD;
        public TextView etE;

        private C0410b() {
        }
    }
}
