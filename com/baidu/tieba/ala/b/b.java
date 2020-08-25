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
    private static int fSr;
    private CommonEmptyView bgl;
    private BdGridView fSs;
    private a fSt;
    private List<g> fSu;
    private g fSv;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        fSr = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bIA() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        this.fSs = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.fSs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.fSv = (g) b.this.fSu.get(i);
                b.this.fSG = b.this.fSv.DR();
                b.this.fSt.Fd(b.this.fSG);
            }
        });
        this.bgl = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
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
    public void aF(int i, String str) {
        ajN();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fSv != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.fSv.DS());
                jSONObject.put("gift_url", this.fSv.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.fSv.DR());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.fSE.setResult(-1, intent);
        }
        this.fSE.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.GY())) {
            showNoDataView();
            return;
        }
        this.fSs.setVisibility(0);
        this.bgl.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.w.a.Nk().bka.aJJ.aLH;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.w.a.Nk().bka.aJJ.aLG;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.w.a.Nk().bka.aJJ.aLI : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.GY().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.fSu = next.Er();
                break;
            }
        }
        if (ListUtils.isEmpty(this.fSu)) {
            showNoDataView();
        } else {
            bIC();
        }
    }

    private void ajN() {
        bGa();
    }

    private void showNoDataView() {
        bGa();
    }

    private void bGa() {
        this.fSs.setVisibility(8);
        this.bgl.setVisibility(0);
        this.bgl.reset();
        this.bgl.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bgl.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bgl.setVisibility(8);
                b.this.bG(b.this.bgl);
            }
        });
        this.bgl.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bgl.setVisibility(0);
    }

    private void bIC() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.fSu) {
            if (gVar != null && gVar.DR() != null) {
                if (gVar.DR().equals(this.fSG)) {
                    this.fSv = gVar;
                }
                if (!ListUtils.isEmpty(this.fuv) && this.fuv.contains(gVar.DR())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.fSu.removeAll(arrayList);
        }
        this.fSt = new a(this.fSE.getPageContext());
        this.fSs.setAdapter((ListAdapter) this.fSt);
        this.fSt.Fc(this.fSG);
        this.fSt.setData(this.fSu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String fuu;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void Fc(String str) {
            this.fuu = str;
        }

        public void Fd(String str) {
            if (this.fuu == null || !this.fuu.equals(str)) {
                this.fuu = str;
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
                layoutParams.width = b.fSr;
                layoutParams.height = b.fSr;
                view.setLayoutParams(layoutParams);
                c0594b2.fSx = (FrameLayout) view.findViewById(a.g.item_root);
                c0594b2.fSy = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0594b2.fSy.setDefaultBgResource(a.f.icon_live_gift_default);
                c0594b2.fSy.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0594b2.fSy.setAutoChangeStyle(false);
                c0594b2.fSz = (TextView) view.findViewById(a.g.item_gift_title);
                c0594b2.aQm = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0594b2);
                c0594b = c0594b2;
            } else {
                c0594b = (C0594b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0594b.fSy.startLoad(item.getThumbnail_url(), 10, false);
                c0594b.fSz.setText(item.DS());
                a(c0594b.aQm, item.getPrice());
                if (item.DR().equals(this.fuu)) {
                    c0594b.fSx.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0594b.fSx.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.w.a.Nk().beH.aGH) {
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
        public TextView aQm;
        public FrameLayout fSx;
        public TbImageView fSy;
        public TextView fSz;

        private C0594b() {
        }
    }
}
