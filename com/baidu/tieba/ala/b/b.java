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
/* loaded from: classes7.dex */
public class b extends d {
    private static int fSv;
    private CommonEmptyView bgn;
    private BdGridView fSw;
    private a fSx;
    private List<g> fSy;
    private g fSz;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        fSv = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bIB() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        this.fSw = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.fSw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.fSz = (g) b.this.fSy.get(i);
                b.this.fSK = b.this.fSz.DR();
                b.this.fSx.Fe(b.this.fSK);
            }
        });
        this.bgn = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void f(TextView textView) {
        textView.setText(a.i.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void aE(int i, String str) {
        ajN();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fSz != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.fSz.DS());
                jSONObject.put("gift_url", this.fSz.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.fSz.DR());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.fSI.setResult(-1, intent);
        }
        this.fSI.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.GY())) {
            showNoDataView();
            return;
        }
        this.fSw.setVisibility(0);
        this.bgn.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.w.a.Nk().bkd.aJL.aLJ;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.w.a.Nk().bkd.aJL.aLI;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.w.a.Nk().bkd.aJL.aLK : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.GY().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.fSy = next.Er();
                break;
            }
        }
        if (ListUtils.isEmpty(this.fSy)) {
            showNoDataView();
        } else {
            bID();
        }
    }

    private void ajN() {
        bGb();
    }

    private void showNoDataView() {
        bGb();
    }

    private void bGb() {
        this.fSw.setVisibility(8);
        this.bgn.setVisibility(0);
        this.bgn.reset();
        this.bgn.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bgn.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bgn.setVisibility(8);
                b.this.bG(b.this.bgn);
            }
        });
        this.bgn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bgn.setVisibility(0);
    }

    private void bID() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.fSy) {
            if (gVar != null && gVar.DR() != null) {
                if (gVar.DR().equals(this.fSK)) {
                    this.fSz = gVar;
                }
                if (!ListUtils.isEmpty(this.fuz) && this.fuz.contains(gVar.DR())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.fSy.removeAll(arrayList);
        }
        this.fSx = new a(this.fSI.getPageContext());
        this.fSw.setAdapter((ListAdapter) this.fSx);
        this.fSx.Fd(this.fSK);
        this.fSx.setData(this.fSy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String fuy;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void Fd(String str) {
            this.fuy = str;
        }

        public void Fe(String str) {
            if (this.fuy == null || !this.fuy.equals(str)) {
                this.fuy = str;
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
        /* renamed from: dV */
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
            C0594b c0594b;
            if (view == null) {
                C0594b c0594b2 = new C0594b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.fSv;
                layoutParams.height = b.fSv;
                view.setLayoutParams(layoutParams);
                c0594b2.fSB = (FrameLayout) view.findViewById(a.g.item_root);
                c0594b2.fSC = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0594b2.fSC.setDefaultBgResource(a.f.icon_live_gift_default);
                c0594b2.fSC.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0594b2.fSC.setAutoChangeStyle(false);
                c0594b2.fSD = (TextView) view.findViewById(a.g.item_gift_title);
                c0594b2.aQo = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0594b2);
                c0594b = c0594b2;
            } else {
                c0594b = (C0594b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0594b.fSC.startLoad(item.getThumbnail_url(), 10, false);
                c0594b.fSD.setText(item.DS());
                a(c0594b.aQo, item.getPrice());
                if (item.DR().equals(this.fuy)) {
                    c0594b.fSB.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0594b.fSB.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.w.a.Nk().beJ.aGJ) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0594b {
        public TextView aQo;
        public FrameLayout fSB;
        public TbImageView fSC;
        public TextView fSD;

        private C0594b() {
        }
    }
}
