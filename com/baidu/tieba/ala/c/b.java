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
/* loaded from: classes4.dex */
public class b extends d {
    private static int gxP;
    private CommonEmptyView bpJ;
    private BdGridView gxQ;
    private a gxR;
    private List<g> gxS;
    private g gxT;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        gxP = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bRv() {
        return a.g.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gxQ = (BdGridView) this.mRootView.findViewById(a.f.choose_gift_gridview);
        this.gxQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gxT = (g) b.this.gxS.get(i);
                b.this.gyd = b.this.gxT.FT();
                b.this.gxR.GZ(b.this.gyd);
            }
        });
        this.bpJ = (CommonEmptyView) this.mRootView.findViewById(a.f.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void j(TextView textView) {
        textView.setText(a.h.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void aV(int i, String str) {
        arD();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gxT != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.gxT.FU());
                jSONObject.put("gift_url", this.gxT.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.gxT.FT());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.gyc.setResult(-1, intent);
        }
        this.gyc.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.Jp())) {
            showNoDataView();
            return;
        }
        this.gxQ.setVisibility(0);
        this.bpJ.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.aa.a.PQ().btT.aPI.aSu;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.aa.a.PQ().btT.aPI.aSt;
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            i = com.baidu.live.aa.a.PQ().btT.aPI.aSv;
        } else {
            i = TbadkCoreApplication.getInst().isYinbo() ? com.baidu.live.aa.a.PQ().btT.aPI.aSw : 0;
        }
        Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.Jp().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.gxS = next.Gu();
                break;
            }
        }
        if (ListUtils.isEmpty(this.gxS)) {
            showNoDataView();
        } else {
            bRx();
        }
    }

    private void arD() {
        bPe();
    }

    private void showNoDataView() {
        bPe();
    }

    private void bPe() {
        this.gxQ.setVisibility(8);
        this.bpJ.setVisibility(0);
        this.bpJ.reset();
        this.bpJ.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bpJ.setVisibility(8);
                b.this.bV(b.this.bpJ);
            }
        });
        this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bpJ.setVisibility(0);
    }

    private void bRx() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.gxS) {
            if (gVar != null && gVar.FT() != null) {
                if (gVar.FT().equals(this.gyd)) {
                    this.gxT = gVar;
                }
                if (!ListUtils.isEmpty(this.fYd) && this.fYd.contains(gVar.FT())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.gxS.removeAll(arrayList);
        }
        this.gxR = new a(this.gyc.getPageContext());
        this.gxQ.setAdapter((ListAdapter) this.gxR);
        this.gxR.GY(this.gyd);
        this.gxR.setData(this.gxS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String fYc;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void GY(String str) {
            this.fYc = str;
        }

        public void GZ(String str) {
            if (this.fYc == null || !this.fYc.equals(str)) {
                this.fYc = str;
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
        /* renamed from: ef */
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
            C0635b c0635b;
            if (view == null) {
                C0635b c0635b2 = new C0635b();
                view = LayoutInflater.from(this.mContext).inflate(a.g.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.gxP;
                layoutParams.height = b.gxP;
                view.setLayoutParams(layoutParams);
                c0635b2.gxV = (FrameLayout) view.findViewById(a.f.item_root);
                c0635b2.gxW = (TbImageView) view.findViewById(a.f.item_gift_img);
                c0635b2.gxW.setDefaultBgResource(a.e.icon_live_gift_default);
                c0635b2.gxW.setDefaultErrorResource(a.e.icon_live_gift_default);
                c0635b2.gxW.setAutoChangeStyle(false);
                c0635b2.gxX = (TextView) view.findViewById(a.f.item_gift_title);
                c0635b2.aYp = (TextView) view.findViewById(a.f.item_gift_price);
                view.setTag(c0635b2);
                c0635b = c0635b2;
            } else {
                c0635b = (C0635b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0635b.gxW.startLoad(item.getThumbnail_url(), 10, false);
                c0635b.gxX.setText(item.FU());
                b(c0635b.aYp, item.getPrice());
                if (item.FT().equals(this.fYc)) {
                    c0635b.gxV.setBackgroundResource(a.e.choose_gift_chosen_bg);
                } else {
                    c0635b.gxV.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
                }
            }
            return view;
        }

        private void b(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.aa.a.PQ().bod.aMG) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.h.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0635b {
        public TextView aYp;
        public FrameLayout gxV;
        public TbImageView gxW;
        public TextView gxX;

        private C0635b() {
        }
    }
}
