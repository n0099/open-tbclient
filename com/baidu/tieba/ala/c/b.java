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
/* loaded from: classes11.dex */
public class b extends d {
    private static int gRY;
    private CommonEmptyView bxT;
    private BdGridView gRZ;
    private a gSa;
    private List<g> gSb;
    private g gSc;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        gRY = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bXe() {
        return a.g.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gRZ = (BdGridView) this.mRootView.findViewById(a.f.choose_gift_gridview);
        this.gRZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gSc = (g) b.this.gSb.get(i);
                b.this.gSm = b.this.gSc.Gx();
                b.this.gSa.Hn(b.this.gSm);
            }
        });
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.choose_gift_empty_view);
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
    public void aV(int i, String str) {
        avv();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gSc != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.gSc.Gy());
                jSONObject.put("gift_url", this.gSc.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.gSc.Gx());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.gSl.setResult(-1, intent);
        }
        this.gSl.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.Kh())) {
            showNoDataView();
            return;
        }
        this.gRZ.setVisibility(0);
        this.bxT.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.af.a.SE().bCb.aRM.aUJ;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.af.a.SE().bCb.aRM.aUI;
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            i = com.baidu.live.af.a.SE().bCb.aRM.aUK;
        } else {
            i = TbadkCoreApplication.getInst().isYinbo() ? com.baidu.live.af.a.SE().bCb.aRM.aUL : 0;
        }
        Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.Kh().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.gSb = next.Hb();
                break;
            }
        }
        if (ListUtils.isEmpty(this.gSb)) {
            showNoDataView();
        } else {
            bXg();
        }
    }

    private void avv() {
        bUM();
    }

    private void showNoDataView() {
        bUM();
    }

    private void bUM() {
        this.gRZ.setVisibility(8);
        this.bxT.setVisibility(0);
        this.bxT.reset();
        this.bxT.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bxT.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bxT.setVisibility(8);
                b.this.co(b.this.bxT);
            }
        });
        this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bxT.setVisibility(0);
    }

    private void bXg() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.gSb) {
            if (gVar != null && gVar.Gx() != null) {
                if (gVar.Gx().equals(this.gSm)) {
                    this.gSc = gVar;
                }
                if (!ListUtils.isEmpty(this.gqb) && this.gqb.contains(gVar.Gx())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.gSb.removeAll(arrayList);
        }
        this.gSa = new a(this.gSl.getPageContext());
        this.gRZ.setAdapter((ListAdapter) this.gSa);
        this.gSa.Hm(this.gSm);
        this.gSa.setData(this.gSb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String gqa;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void Hm(String str) {
            this.gqa = str;
        }

        public void Hn(String str) {
            if (this.gqa == null || !this.gqa.equals(str)) {
                this.gqa = str;
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
        /* renamed from: et */
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
            C0638b c0638b;
            if (view == null) {
                C0638b c0638b2 = new C0638b();
                view = LayoutInflater.from(this.mContext).inflate(a.g.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.gRY;
                layoutParams.height = b.gRY;
                view.setLayoutParams(layoutParams);
                c0638b2.gSe = (FrameLayout) view.findViewById(a.f.item_root);
                c0638b2.gSf = (TbImageView) view.findViewById(a.f.item_gift_img);
                c0638b2.gSf.setDefaultBgResource(a.e.icon_live_gift_default);
                c0638b2.gSf.setDefaultErrorResource(a.e.icon_live_gift_default);
                c0638b2.gSf.setAutoChangeStyle(false);
                c0638b2.gSg = (TextView) view.findViewById(a.f.item_gift_title);
                c0638b2.bbB = (TextView) view.findViewById(a.f.item_gift_price);
                view.setTag(c0638b2);
                c0638b = c0638b2;
            } else {
                c0638b = (C0638b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0638b.gSf.startLoad(item.getThumbnail_url(), 10, false);
                c0638b.gSg.setText(item.Gy());
                c(c0638b.bbB, item.getPrice());
                if (item.Gx().equals(this.gqa)) {
                    c0638b.gSe.setBackgroundResource(a.e.choose_gift_chosen_bg);
                } else {
                    c0638b.gSe.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
                }
            }
            return view;
        }

        private void c(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.af.a.SE().bwi.aOu) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.h.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0638b {
        public TextView bbB;
        public FrameLayout gSe;
        public TbImageView gSf;
        public TextView gSg;

        private C0638b() {
        }
    }
}
