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
import com.baidu.live.gift.i;
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
    private static int fVF;
    private CommonEmptyView bjf;
    private BdGridView fVG;
    private a fVH;
    private List<g> fVI;
    private g fVJ;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        fVF = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bJJ() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.fVG = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.fVG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.fVJ = (g) b.this.fVI.get(i);
                b.this.fVU = b.this.fVJ.Eh();
                b.this.fVH.FC(b.this.fVU);
            }
        });
        this.bjf = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void f(TextView textView) {
        textView.setText(a.i.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void aF(int i, String str) {
        akx();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.fVJ != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.fVJ.Ei());
                jSONObject.put("gift_url", this.fVJ.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.fVJ.Eh());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.fVS.setResult(-1, intent);
        }
        this.fVS.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.Hy())) {
            showNoDataView();
            return;
        }
        this.fVG.setVisibility(0);
        this.bjf.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.x.a.NN().bmW.aLb.aNs;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.x.a.NN().bmW.aLb.aNr;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.x.a.NN().bmW.aLb.aNt : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.Hy().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.fVI = next.EI();
                break;
            }
        }
        if (ListUtils.isEmpty(this.fVI)) {
            showNoDataView();
        } else {
            bJL();
        }
    }

    private void akx() {
        bHr();
    }

    private void showNoDataView() {
        bHr();
    }

    private void bHr() {
        this.fVG.setVisibility(8);
        this.bjf.setVisibility(0);
        this.bjf.reset();
        this.bjf.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bjf.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bjf.setVisibility(8);
                b.this.bK(b.this.bjf);
            }
        });
        this.bjf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bjf.setVisibility(0);
    }

    private void bJL() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.fVI) {
            if (gVar != null && gVar.Eh() != null) {
                if (gVar.Eh().equals(this.fVU)) {
                    this.fVJ = gVar;
                }
                if (!ListUtils.isEmpty(this.fxK) && this.fxK.contains(gVar.Eh())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.fVI.removeAll(arrayList);
        }
        this.fVH = new a(this.fVS.getPageContext());
        this.fVG.setAdapter((ListAdapter) this.fVH);
        this.fVH.FB(this.fVU);
        this.fVH.setData(this.fVI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String fxJ;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void FB(String str) {
            this.fxJ = str;
        }

        public void FC(String str) {
            if (this.fxJ == null || !this.fxJ.equals(str)) {
                this.fxJ = str;
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
        /* renamed from: dZ */
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
            C0590b c0590b;
            if (view == null) {
                C0590b c0590b2 = new C0590b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.fVF;
                layoutParams.height = b.fVF;
                view.setLayoutParams(layoutParams);
                c0590b2.fVL = (FrameLayout) view.findViewById(a.g.item_root);
                c0590b2.fVM = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0590b2.fVM.setDefaultBgResource(a.f.icon_live_gift_default);
                c0590b2.fVM.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0590b2.fVM.setAutoChangeStyle(false);
                c0590b2.fVN = (TextView) view.findViewById(a.g.item_gift_title);
                c0590b2.aSr = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0590b2);
                c0590b = c0590b2;
            } else {
                c0590b = (C0590b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0590b.fVM.startLoad(item.getThumbnail_url(), 10, false);
                c0590b.fVN.setText(item.Ei());
                b(c0590b.aSr, item.getPrice());
                if (item.Eh().equals(this.fxJ)) {
                    c0590b.fVL.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0590b.fVL.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void b(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.x.a.NN().bhy.aHY) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0590b {
        public TextView aSr;
        public FrameLayout fVL;
        public TbImageView fVM;
        public TextView fVN;

        private C0590b() {
        }
    }
}
