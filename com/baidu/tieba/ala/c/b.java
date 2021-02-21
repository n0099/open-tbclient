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
    private static int gQm;
    private CommonEmptyView bwJ;
    private BdGridView gQn;
    private a gQo;
    private List<g> gQp;
    private g gQq;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        this.gQn = (BdGridView) this.mRootView.findViewById(a.f.choose_gift_gridview);
        this.gQn.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                b.this.gQq = (g) b.this.gQp.get(i3);
                b.this.gQA = b.this.gQq.DR();
                b.this.gQo.GC(b.this.gQA);
            }
        });
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.choose_gift_empty_view);
        gQm = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bTX() {
        return a.g.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gQn = (BdGridView) this.mRootView.findViewById(a.f.choose_gift_gridview);
        this.gQn.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gQq = (g) b.this.gQp.get(i);
                b.this.gQA = b.this.gQq.DR();
                b.this.gQo.GC(b.this.gQA);
            }
        });
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.choose_gift_empty_view);
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
        arY();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gQq != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.gQq.DS());
                jSONObject.put("gift_url", this.gQq.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.gQq.DR());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.gQz.setResult(-1, intent);
        }
        this.gQz.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.HC())) {
            showNoDataView();
            return;
        }
        this.gQn.setVisibility(0);
        this.bwJ.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.ae.a.Qj().bAS.aPX.aSZ;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.ae.a.Qj().bAS.aPX.aSY;
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            i = com.baidu.live.ae.a.Qj().bAS.aPX.aTa;
        } else {
            i = TbadkCoreApplication.getInst().isYinbo() ? com.baidu.live.ae.a.Qj().bAS.aPX.aTb : 0;
        }
        Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.HC().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.gQp = next.Ew();
                break;
            }
        }
        if (ListUtils.isEmpty(this.gQp)) {
            showNoDataView();
        } else {
            bTZ();
        }
    }

    private void arY() {
        bRF();
    }

    private void showNoDataView() {
        bRF();
    }

    private void bRF() {
        this.gQn.setVisibility(8);
        this.bwJ.setVisibility(0);
        this.bwJ.reset();
        this.bwJ.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bwJ.setVisibility(8);
                b.this.ck(b.this.bwJ);
            }
        });
        this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bwJ.setVisibility(0);
    }

    private void bTZ() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.gQp) {
            if (gVar != null && gVar.DR() != null) {
                if (gVar.DR().equals(this.gQA)) {
                    this.gQq = gVar;
                }
                if (!ListUtils.isEmpty(this.goo) && this.goo.contains(gVar.DR())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.gQp.removeAll(arrayList);
        }
        this.gQo = new a(this.gQz.getPageContext());
        this.gQn.setAdapter((ListAdapter) this.gQo);
        this.gQo.GB(this.gQA);
        this.gQo.setData(this.gQp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String gon;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void GB(String str) {
            this.gon = str;
        }

        public void GC(String str) {
            if (this.gon == null || !this.gon.equals(str)) {
                this.gon = str;
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
        /* renamed from: cS */
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
                layoutParams.width = b.gQm;
                layoutParams.height = b.gQm;
                view.setLayoutParams(layoutParams);
                c0621b2.gQs = (FrameLayout) view.findViewById(a.f.item_root);
                c0621b2.gQt = (TbImageView) view.findViewById(a.f.item_gift_img);
                c0621b2.gQt.setDefaultBgResource(a.e.icon_live_gift_default);
                c0621b2.gQt.setDefaultErrorResource(a.e.icon_live_gift_default);
                c0621b2.gQt.setAutoChangeStyle(false);
                c0621b2.gQu = (TextView) view.findViewById(a.f.item_gift_title);
                c0621b2.aZT = (TextView) view.findViewById(a.f.item_gift_price);
                view.setTag(c0621b2);
                c0621b = c0621b2;
            } else {
                c0621b = (C0621b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0621b.gQt.startLoad(item.getThumbnail_url(), 10, false);
                c0621b.gQu.setText(item.DS());
                c(c0621b.aZT, item.getPrice());
                if (item.DR().equals(this.gon)) {
                    c0621b.gQs.setBackgroundResource(a.e.choose_gift_chosen_bg);
                } else {
                    c0621b.gQs.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
                }
            }
            return view;
        }

        private void c(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.ae.a.Qj().buX.aMr) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.h.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0621b {
        public TextView aZT;
        public FrameLayout gQs;
        public TbImageView gQt;
        public TextView gQu;

        private C0621b() {
        }
    }
}
