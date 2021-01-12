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
    private static int gNs;
    private CommonEmptyView btf;
    private BdGridView gNt;
    private a gNu;
    private List<g> gNv;
    private g gNw;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        gNs = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bTm() {
        return a.g.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gNt = (BdGridView) this.mRootView.findViewById(a.f.choose_gift_gridview);
        this.gNt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gNw = (g) b.this.gNv.get(i);
                b.this.gNG = b.this.gNw.CC();
                b.this.gNu.Gc(b.this.gNG);
            }
        });
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.choose_gift_empty_view);
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
    public void aW(int i, String str) {
        arA();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gNw != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.gNw.CD());
                jSONObject.put("gift_url", this.gNw.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.gNw.CC());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.gNF.setResult(-1, intent);
        }
        this.gNF.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.Gm())) {
            showNoDataView();
            return;
        }
        this.gNt.setVisibility(0);
        this.btf.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.af.a.OJ().bxp.aMZ.aPW;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.af.a.OJ().bxp.aMZ.aPV;
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            i = com.baidu.live.af.a.OJ().bxp.aMZ.aPX;
        } else {
            i = TbadkCoreApplication.getInst().isYinbo() ? com.baidu.live.af.a.OJ().bxp.aMZ.aPY : 0;
        }
        Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.Gm().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.gNv = next.Dg();
                break;
            }
        }
        if (ListUtils.isEmpty(this.gNv)) {
            showNoDataView();
        } else {
            bTo();
        }
    }

    private void arA() {
        bQU();
    }

    private void showNoDataView() {
        bQU();
    }

    private void bQU() {
        this.gNt.setVisibility(8);
        this.btf.setVisibility(0);
        this.btf.reset();
        this.btf.setTitle(a.h.sdk_net_fail_tip_rank);
        this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.btf.setVisibility(8);
                b.this.co(b.this.btf);
            }
        });
        this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btf.setVisibility(0);
    }

    private void bTo() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.gNv) {
            if (gVar != null && gVar.CC() != null) {
                if (gVar.CC().equals(this.gNG)) {
                    this.gNw = gVar;
                }
                if (!ListUtils.isEmpty(this.glu) && this.glu.contains(gVar.CC())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.gNv.removeAll(arrayList);
        }
        this.gNu = new a(this.gNF.getPageContext());
        this.gNt.setAdapter((ListAdapter) this.gNu);
        this.gNu.Gb(this.gNG);
        this.gNu.setData(this.gNv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String glt;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void Gb(String str) {
            this.glt = str;
        }

        public void Gc(String str) {
            if (this.glt == null || !this.glt.equals(str)) {
                this.glt = str;
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
        /* renamed from: cN */
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
            C0621b c0621b;
            if (view == null) {
                C0621b c0621b2 = new C0621b();
                view = LayoutInflater.from(this.mContext).inflate(a.g.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.gNs;
                layoutParams.height = b.gNs;
                view.setLayoutParams(layoutParams);
                c0621b2.gNy = (FrameLayout) view.findViewById(a.f.item_root);
                c0621b2.gNz = (TbImageView) view.findViewById(a.f.item_gift_img);
                c0621b2.gNz.setDefaultBgResource(a.e.icon_live_gift_default);
                c0621b2.gNz.setDefaultErrorResource(a.e.icon_live_gift_default);
                c0621b2.gNz.setAutoChangeStyle(false);
                c0621b2.gNA = (TextView) view.findViewById(a.f.item_gift_title);
                c0621b2.aWN = (TextView) view.findViewById(a.f.item_gift_price);
                view.setTag(c0621b2);
                c0621b = c0621b2;
            } else {
                c0621b = (C0621b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0621b.gNz.startLoad(item.getThumbnail_url(), 10, false);
                c0621b.gNA.setText(item.CD());
                c(c0621b.aWN, item.getPrice());
                if (item.CC().equals(this.glt)) {
                    c0621b.gNy.setBackgroundResource(a.e.choose_gift_chosen_bg);
                } else {
                    c0621b.gNy.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
                }
            }
            return view;
        }

        private void c(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.af.a.OJ().bru.aJH) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.h.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0621b {
        public TextView aWN;
        public TextView gNA;
        public FrameLayout gNy;
        public TbImageView gNz;

        private C0621b() {
        }
    }
}
