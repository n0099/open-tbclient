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
    private static int fHa;
    private CommonEmptyView baQ;
    private BdGridView fHb;
    private a fHc;
    private List<g> fHd;
    private g fHe;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        fHa = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bzx() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        this.fHb = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.fHb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.fHe = (g) b.this.fHd.get(i);
                b.this.fHp = b.this.fHe.yo();
                b.this.fHc.CI(b.this.fHp);
            }
        });
        this.baQ = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void g(TextView textView) {
        textView.setText(a.i.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void aH(int i, String str) {
        ads();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fHe != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.fHe.yp());
                jSONObject.put("gift_url", this.fHe.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.fHe.yo());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.fHn.setResult(-1, intent);
        }
        this.fHn.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.Bv())) {
            showNoDataView();
            return;
        }
        this.fHb.setVisibility(0);
        this.baQ.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.v.a.Hs().beo.aEz.aGx;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.v.a.Hs().beo.aEz.aGw;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.v.a.Hs().beo.aEz.aGy : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.Bv().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.fHd = next.yO();
                break;
            }
        }
        if (ListUtils.isEmpty(this.fHd)) {
            showNoDataView();
        } else {
            bzz();
        }
    }

    private void ads() {
        bxb();
    }

    private void showNoDataView() {
        bxb();
    }

    private void bxb() {
        this.fHb.setVisibility(8);
        this.baQ.setVisibility(0);
        this.baQ.reset();
        this.baQ.setTitle(a.i.sdk_net_fail_tip_rank);
        this.baQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.baQ.setVisibility(8);
                b.this.bE(b.this.baQ);
            }
        });
        this.baQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.baQ.setVisibility(0);
    }

    private void bzz() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.fHd) {
            if (gVar != null && gVar.yo() != null) {
                if (gVar.yo().equals(this.fHp)) {
                    this.fHe = gVar;
                }
                if (!ListUtils.isEmpty(this.fiZ) && this.fiZ.contains(gVar.yo())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.fHd.removeAll(arrayList);
        }
        this.fHc = new a(this.fHn.getPageContext());
        this.fHb.setAdapter((ListAdapter) this.fHc);
        this.fHc.CH(this.fHp);
        this.fHc.setData(this.fHd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String fiY;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void CH(String str) {
            this.fiY = str;
        }

        public void CI(String str) {
            if (this.fiY == null || !this.fiY.equals(str)) {
                this.fiY = str;
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
        /* renamed from: cg */
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
            C0548b c0548b;
            if (view == null) {
                C0548b c0548b2 = new C0548b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.fHa;
                layoutParams.height = b.fHa;
                view.setLayoutParams(layoutParams);
                c0548b2.fHg = (FrameLayout) view.findViewById(a.g.item_root);
                c0548b2.fHh = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0548b2.fHh.setDefaultBgResource(a.f.icon_live_gift_default);
                c0548b2.fHh.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0548b2.fHh.setAutoChangeStyle(false);
                c0548b2.fHi = (TextView) view.findViewById(a.g.item_gift_title);
                c0548b2.aKZ = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0548b2);
                c0548b = c0548b2;
            } else {
                c0548b = (C0548b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0548b.fHh.startLoad(item.getThumbnail_url(), 10, false);
                c0548b.fHi.setText(item.yp());
                a(c0548b.aKZ, item.getPrice());
                if (item.yo().equals(this.fiY)) {
                    c0548b.fHg.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0548b.fHg.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.v.a.Hs().aZn.aBx) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0548b {
        public TextView aKZ;
        public FrameLayout fHg;
        public TbImageView fHh;
        public TextView fHi;

        private C0548b() {
        }
    }
}
