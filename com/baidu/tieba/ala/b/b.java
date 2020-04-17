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
    private static int fcM;
    private CommonEmptyView faB;
    private BdGridView fcN;
    private a fcO;
    private List<g> fcP;
    private g fcQ;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        fcM = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bnw() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        this.fcN = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.fcN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.fcQ = (g) b.this.fcP.get(i);
                b.this.fdb = b.this.fcQ.vV();
                b.this.fcO.zP(b.this.fdb);
            }
        });
        this.faB = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
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
        Ym();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fcQ != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.fcQ.vW());
                jSONObject.put("gift_url", this.fcQ.vY());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.fcQ.vV());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.fcZ.setResult(-1, intent);
        }
        this.fcZ.finish();
    }

    private void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.zg())) {
            showNoDataView();
            return;
        }
        this.fcN.setVisibility(0);
        this.faB.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.v.a.Eo().aRw.avF.axo;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.v.a.Eo().aRw.avF.axn;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.v.a.Eo().aRw.avF.axp : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.zg().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.fcP = next.ww();
                break;
            }
        }
        if (ListUtils.isEmpty(this.fcP)) {
            showNoDataView();
        } else {
            bny();
        }
    }

    private void Ym() {
        aqF();
    }

    private void showNoDataView() {
        aqF();
    }

    private void aqF() {
        this.fcN.setVisibility(8);
        this.faB.setVisibility(0);
        this.faB.reset();
        this.faB.setTitle(a.i.sdk_net_fail_tip_rank);
        this.faB.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.faB.setVisibility(8);
                b.this.bw(b.this.faB);
            }
        });
        this.faB.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.faB.setVisibility(0);
    }

    private void bny() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.fcP) {
            if (gVar != null && gVar.vV() != null) {
                if (gVar.vV().equals(this.fdb)) {
                    this.fcQ = gVar;
                }
                if (!ListUtils.isEmpty(this.eHi) && this.eHi.contains(gVar.vV())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.fcP.removeAll(arrayList);
        }
        this.fcO = new a(this.fcZ.getPageContext());
        this.fcN.setAdapter((ListAdapter) this.fcO);
        this.fcO.zO(this.fdb);
        this.fcO.setData(this.fcP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String eHh;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void zO(String str) {
            this.eHh = str;
        }

        public void zP(String str) {
            if (this.eHh == null || !this.eHh.equals(str)) {
                this.eHh = str;
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
            C0461b c0461b;
            if (view == null) {
                C0461b c0461b2 = new C0461b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.fcM;
                layoutParams.height = b.fcM;
                view.setLayoutParams(layoutParams);
                c0461b2.fcS = (FrameLayout) view.findViewById(a.g.item_root);
                c0461b2.fcT = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0461b2.fcT.setDefaultBgResource(a.f.icon_live_gift_default);
                c0461b2.fcT.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0461b2.fcT.setAutoChangeStyle(false);
                c0461b2.fcU = (TextView) view.findViewById(a.g.item_gift_title);
                c0461b2.aBC = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0461b2);
                c0461b = c0461b2;
            } else {
                c0461b = (C0461b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0461b.fcT.startLoad(item.vY(), 10, false);
                c0461b.fcU.setText(item.vW());
                a(c0461b.aBC, item.getPrice());
                if (item.vV().equals(this.eHh)) {
                    c0461b.fcS.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0461b.fcS.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.v.a.Eo().aQp.asP) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0461b {
        public TextView aBC;
        public FrameLayout fcS;
        public TbImageView fcT;
        public TextView fcU;

        private C0461b() {
        }
    }
}
