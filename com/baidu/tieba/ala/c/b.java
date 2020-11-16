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
    private static int gxw;
    private CommonEmptyView bnY;
    private g gxA;
    private BdGridView gxx;
    private a gxy;
    private List<g> gxz;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        gxw = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bQO() {
        return a.g.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gxx = (BdGridView) this.mRootView.findViewById(a.f.choose_gift_gridview);
        this.gxx.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gxA = (g) b.this.gxz.get(i);
                b.this.gxK = b.this.gxA.Fk();
                b.this.gxy.GA(b.this.gxK);
            }
        });
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.choose_gift_empty_view);
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
    public void aT(int i, String str) {
        aqV();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gxA != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.gxA.Fl());
                jSONObject.put("gift_url", this.gxA.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.gxA.Fk());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.gxJ.setResult(-1, intent);
        }
        this.gxJ.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.IG())) {
            showNoDataView();
            return;
        }
        this.gxx.setVisibility(0);
        this.bnY.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.aa.a.Ph().bsh.aNX.aQJ;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.aa.a.Ph().bsh.aNX.aQI;
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            i = com.baidu.live.aa.a.Ph().bsh.aNX.aQK;
        } else {
            i = TbadkCoreApplication.getInst().isYinbo() ? com.baidu.live.aa.a.Ph().bsh.aNX.aQL : 0;
        }
        Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.IG().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.gxz = next.FL();
                break;
            }
        }
        if (ListUtils.isEmpty(this.gxz)) {
            showNoDataView();
        } else {
            bQQ();
        }
    }

    private void aqV() {
        bOx();
    }

    private void showNoDataView() {
        bOx();
    }

    private void bOx() {
        this.gxx.setVisibility(8);
        this.bnY.setVisibility(0);
        this.bnY.reset();
        this.bnY.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bnY.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bnY.setVisibility(8);
                b.this.bY(b.this.bnY);
            }
        });
        this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bnY.setVisibility(0);
    }

    private void bQQ() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.gxz) {
            if (gVar != null && gVar.Fk() != null) {
                if (gVar.Fk().equals(this.gxK)) {
                    this.gxA = gVar;
                }
                if (!ListUtils.isEmpty(this.fXK) && this.fXK.contains(gVar.Fk())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.gxz.removeAll(arrayList);
        }
        this.gxy = new a(this.gxJ.getPageContext());
        this.gxx.setAdapter((ListAdapter) this.gxy);
        this.gxy.Gz(this.gxK);
        this.gxy.setData(this.gxz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String fXJ;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void Gz(String str) {
            this.fXJ = str;
        }

        public void GA(String str) {
            if (this.fXJ == null || !this.fXJ.equals(str)) {
                this.fXJ = str;
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
        /* renamed from: eb */
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
                layoutParams.width = b.gxw;
                layoutParams.height = b.gxw;
                view.setLayoutParams(layoutParams);
                c0635b2.gxC = (FrameLayout) view.findViewById(a.f.item_root);
                c0635b2.gxD = (TbImageView) view.findViewById(a.f.item_gift_img);
                c0635b2.gxD.setDefaultBgResource(a.e.icon_live_gift_default);
                c0635b2.gxD.setDefaultErrorResource(a.e.icon_live_gift_default);
                c0635b2.gxD.setAutoChangeStyle(false);
                c0635b2.gxE = (TextView) view.findViewById(a.f.item_gift_title);
                c0635b2.aWE = (TextView) view.findViewById(a.f.item_gift_price);
                view.setTag(c0635b2);
                c0635b = c0635b2;
            } else {
                c0635b = (C0635b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0635b.gxD.startLoad(item.getThumbnail_url(), 10, false);
                c0635b.gxE.setText(item.Fl());
                b(c0635b.aWE, item.getPrice());
                if (item.Fk().equals(this.fXJ)) {
                    c0635b.gxC.setBackgroundResource(a.e.choose_gift_chosen_bg);
                } else {
                    c0635b.gxC.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
                }
            }
            return view;
        }

        private void b(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.aa.a.Ph().bms.aKV) {
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
        public TextView aWE;
        public FrameLayout gxC;
        public TbImageView gxD;
        public TextView gxE;

        private C0635b() {
        }
    }
}
