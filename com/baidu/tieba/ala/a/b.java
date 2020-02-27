package com.baidu.tieba.ala.a;

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
    private static int exG;
    private CommonEmptyView evQ;
    private BdGridView exH;
    private a exI;
    private List<g> exJ;
    private g exK;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        exG = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.a.d
    protected int getLayoutResId() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.a.d
    protected void initView() {
        this.exH = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.exH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.a.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.exK = (g) b.this.exJ.get(i);
                b.this.exV = b.this.exK.rx();
                b.this.exI.yf(b.this.exV);
            }
        });
        this.evQ = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void d(TextView textView) {
        textView.setText(a.i.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        d(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void aj(int i, String str) {
        Qs();
    }

    @Override // com.baidu.tieba.ala.a.d
    public void confirm() {
        if (this.exK != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.exK.ry());
                jSONObject.put("gift_url", this.exK.rA());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.exK.rx());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.exT.setResult(-1, intent);
        }
        this.exT.finish();
    }

    private void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.uG())) {
            showNoDataView();
            return;
        }
        this.exH.setVisibility(0);
        this.evQ.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.v.a.zj().axB.ade.aeO;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.v.a.zj().axB.ade.aeN;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.v.a.zj().axB.ade.aeP : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.uG().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.exJ = next.rY();
                break;
            }
        }
        if (ListUtils.isEmpty(this.exJ)) {
            showNoDataView();
        } else {
            bea();
        }
    }

    private void Qs() {
        ais();
    }

    private void showNoDataView() {
        ais();
    }

    private void ais() {
        this.exH.setVisibility(8);
        this.evQ.setVisibility(0);
        this.evQ.reset();
        this.evQ.setTitle(a.i.sdk_net_fail_tip_rank);
        this.evQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.evQ.setVisibility(8);
                b.this.bt(b.this.evQ);
            }
        });
        this.evQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.evQ.setVisibility(0);
    }

    private void bea() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.exJ) {
            if (gVar != null && gVar.rx() != null) {
                if (gVar.rx().equals(this.exV)) {
                    this.exK = gVar;
                }
                if (!ListUtils.isEmpty(this.egO) && this.egO.contains(gVar.rx())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.exJ.removeAll(arrayList);
        }
        this.exI = new a(this.exT.getPageContext());
        this.exH.setAdapter((ListAdapter) this.exI);
        this.exI.ye(this.exV);
        this.exI.setData(this.exJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String egN;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void ye(String str) {
            this.egN = str;
        }

        public void yf(String str) {
            if (this.egN == null || !this.egN.equals(str)) {
                this.egN = str;
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
        /* renamed from: by */
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
            C0421b c0421b;
            if (view == null) {
                C0421b c0421b2 = new C0421b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.exG;
                layoutParams.height = b.exG;
                view.setLayoutParams(layoutParams);
                c0421b2.exM = (FrameLayout) view.findViewById(a.g.item_root);
                c0421b2.exN = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0421b2.exN.setDefaultBgResource(a.f.icon_live_gift_default);
                c0421b2.exN.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0421b2.exN.setAutoChangeStyle(false);
                c0421b2.exO = (TextView) view.findViewById(a.g.item_gift_title);
                c0421b2.aiZ = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0421b2);
                c0421b = c0421b2;
            } else {
                c0421b = (C0421b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0421b.exN.startLoad(item.rA(), 10, false);
                c0421b.exO.setText(item.ry());
                a(c0421b.aiZ, item.getPrice());
                if (item.rx().equals(this.egN)) {
                    c0421b.exM.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0421b.exM.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.v.a.zj().awA.aaq) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0421b {
        public TextView aiZ;
        public FrameLayout exM;
        public TbImageView exN;
        public TextView exO;

        private C0421b() {
        }
    }
}
