package com.baidu.tieba.ala.c;

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
import com.baidu.live.gift.h;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.sdk.a;
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
/* loaded from: classes10.dex */
public class b extends d {
    private static int gRV;
    private CommonEmptyView byj;
    private BdGridView gRW;
    private a gRX;
    private List<g> gRY;
    private g gRZ;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        this.gRW = (BdGridView) this.mRootView.findViewById(a.f.choose_gift_gridview);
        this.gRW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                b.this.gRZ = (g) b.this.gRY.get(i3);
                b.this.gSj = b.this.gRZ.DU();
                b.this.gRX.GL(b.this.gSj);
            }
        });
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.choose_gift_empty_view);
        gRV = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bUd() {
        return a.g.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gRW = (BdGridView) this.mRootView.findViewById(a.f.choose_gift_gridview);
        this.gRW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gRZ = (g) b.this.gRY.get(i);
                b.this.gSj = b.this.gRZ.DU();
                b.this.gRX.GL(b.this.gSj);
            }
        });
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void l(TextView textView) {
        textView.setText(a.h.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void bb(int i, String str) {
        asb();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gRZ != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.gRZ.DV());
                jSONObject.put("gift_url", this.gRZ.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.gRZ.DU());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.gSi.setResult(-1, intent);
        }
        this.gSi.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.HF())) {
            showNoDataView();
            return;
        }
        this.gRW.setVisibility(0);
        this.byj.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.ae.a.Qm().bCs.aRx.aUz;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.ae.a.Qm().bCs.aRx.aUy;
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            i = com.baidu.live.ae.a.Qm().bCs.aRx.aUA;
        } else {
            i = TbadkCoreApplication.getInst().isYinbo() ? com.baidu.live.ae.a.Qm().bCs.aRx.aUB : 0;
        }
        Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.HF().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.gRY = next.Ez();
                break;
            }
        }
        if (ListUtils.isEmpty(this.gRY)) {
            showNoDataView();
        } else {
            bUf();
        }
    }

    private void asb() {
        bRL();
    }

    private void showNoDataView() {
        bRL();
    }

    private void bRL() {
        this.gRW.setVisibility(8);
        this.byj.setVisibility(0);
        this.byj.reset();
        this.byj.setTitle(a.h.sdk_net_fail_tip_rank);
        this.byj.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.byj.setVisibility(8);
                b.this.ck(b.this.byj);
            }
        });
        this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.byj.setVisibility(0);
    }

    private void bUf() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.gRY) {
            if (gVar != null && gVar.DU() != null) {
                if (gVar.DU().equals(this.gSj)) {
                    this.gRZ = gVar;
                }
                if (!ListUtils.isEmpty(this.gpX) && this.gpX.contains(gVar.DU())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.gRY.removeAll(arrayList);
        }
        this.gRX = new a(this.gSi.getPageContext());
        this.gRW.setAdapter((ListAdapter) this.gRX);
        this.gRX.GK(this.gSj);
        this.gRX.setData(this.gRY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String gpW;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void GK(String str) {
            this.gpW = str;
        }

        public void GL(String str) {
            if (this.gpW == null || !this.gpW.equals(str)) {
                this.gpW = str;
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
        /* renamed from: cT */
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
            C0627b c0627b;
            if (view == null) {
                C0627b c0627b2 = new C0627b();
                view = LayoutInflater.from(this.mContext).inflate(a.g.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.gRV;
                layoutParams.height = b.gRV;
                view.setLayoutParams(layoutParams);
                c0627b2.gSb = (FrameLayout) view.findViewById(a.f.item_root);
                c0627b2.gSc = (TbImageView) view.findViewById(a.f.item_gift_img);
                c0627b2.gSc.setDefaultBgResource(a.e.icon_live_gift_default);
                c0627b2.gSc.setDefaultErrorResource(a.e.icon_live_gift_default);
                c0627b2.gSc.setAutoChangeStyle(false);
                c0627b2.gSd = (TextView) view.findViewById(a.f.item_gift_title);
                c0627b2.bbu = (TextView) view.findViewById(a.f.item_gift_price);
                view.setTag(c0627b2);
                c0627b = c0627b2;
            } else {
                c0627b = (C0627b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0627b.gSc.startLoad(item.getThumbnail_url(), 10, false);
                c0627b.gSd.setText(item.DV());
                c(c0627b.bbu, item.getPrice());
                if (item.DU().equals(this.gpW)) {
                    c0627b.gSb.setBackgroundResource(a.e.choose_gift_chosen_bg);
                } else {
                    c0627b.gSb.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
                }
            }
            return view;
        }

        private void c(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.ae.a.Qm().bwx.aNR) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.h.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0627b {
        public TextView bbu;
        public FrameLayout gSb;
        public TbImageView gSc;
        public TextView gSd;

        private C0627b() {
        }
    }
}
