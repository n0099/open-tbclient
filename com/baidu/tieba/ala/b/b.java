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
/* loaded from: classes3.dex */
public class b extends d {
    private static int fBQ;
    private CommonEmptyView baR;
    private BdGridView fBR;
    private a fBS;
    private List<g> fBT;
    private g fBU;

    public b(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
        initView();
        fBQ = (int) (BdUtilHelper.getScreenDimensions(this.mContext)[0] / 4.0d);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bwj() {
        return a.h.ala_choose_gift;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        this.fBR = (BdGridView) this.mRootView.findViewById(a.g.choose_gift_gridview);
        this.fBR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.fBU = (g) b.this.fBT.get(i);
                b.this.fCf = b.this.fBU.xM();
                b.this.fBS.BX(b.this.fCf);
            }
        });
        this.baR = (CommonEmptyView) this.mRootView.findViewById(a.g.choose_gift_empty_view);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void e(TextView textView) {
        textView.setText(a.i.sdk_choose_gift_title);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void aF(int i, String str) {
        acn();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fBU != null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gift_title", this.fBU.xN());
                jSONObject.put("gift_url", this.fBU.getThumbnail_url());
                jSONObject.put(LogConfig.LOG_GIFT_ID, this.fBU.xM());
                intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.fCd.setResult(-1, intent);
        }
        this.fCd.finish();
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        int i;
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.AT())) {
            showNoDataView();
            return;
        }
        this.fBR.setVisibility(0);
        this.baR.setVisibility(8);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = com.baidu.live.v.a.Hm().bdV.aDe.aFc;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = com.baidu.live.v.a.Hm().bdV.aDe.aFb;
        } else {
            i = TbadkCoreApplication.getInst().isQuanmin() ? com.baidu.live.v.a.Hm().bdV.aDe.aFd : 0;
        }
        Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.AT().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            if (next != null && i == next.getCategoryId()) {
                this.fBT = next.ym();
                break;
            }
        }
        if (ListUtils.isEmpty(this.fBT)) {
            showNoDataView();
        } else {
            bwl();
        }
    }

    private void acn() {
        btS();
    }

    private void showNoDataView() {
        btS();
    }

    private void btS() {
        this.fBR.setVisibility(8);
        this.baR.setVisibility(0);
        this.baR.reset();
        this.baR.setTitle(a.i.sdk_net_fail_tip_rank);
        this.baR.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.baR.setVisibility(8);
                b.this.by(b.this.baR);
            }
        });
        this.baR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.baR.setVisibility(0);
    }

    private void bwl() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.fBT) {
            if (gVar != null && gVar.xM() != null) {
                if (gVar.xM().equals(this.fCf)) {
                    this.fBU = gVar;
                }
                if (!ListUtils.isEmpty(this.feg) && this.feg.contains(gVar.xM())) {
                    arrayList.add(gVar);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.fBT.removeAll(arrayList);
        }
        this.fBS = new a(this.fCd.getPageContext());
        this.fBR.setAdapter((ListAdapter) this.fBS);
        this.fBS.BW(this.fCf);
        this.fBS.setData(this.fBT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private String fef;
        private Context mContext;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void BW(String str) {
            this.fef = str;
        }

        public void BX(String str) {
            if (this.fef == null || !this.fef.equals(str)) {
                this.fef = str;
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
        /* renamed from: ca */
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
            C0537b c0537b;
            if (view == null) {
                C0537b c0537b2 = new C0537b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_gift_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = b.fBQ;
                layoutParams.height = b.fBQ;
                view.setLayoutParams(layoutParams);
                c0537b2.fBW = (FrameLayout) view.findViewById(a.g.item_root);
                c0537b2.fBX = (TbImageView) view.findViewById(a.g.item_gift_img);
                c0537b2.fBX.setDefaultBgResource(a.f.icon_live_gift_default);
                c0537b2.fBX.setDefaultErrorResource(a.f.icon_live_gift_default);
                c0537b2.fBX.setAutoChangeStyle(false);
                c0537b2.fBY = (TextView) view.findViewById(a.g.item_gift_title);
                c0537b2.aJD = (TextView) view.findViewById(a.g.item_gift_price);
                view.setTag(c0537b2);
                c0537b = c0537b2;
            } else {
                c0537b = (C0537b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                c0537b.fBX.startLoad(item.getThumbnail_url(), 10, false);
                c0537b.fBY.setText(item.xN());
                a(c0537b.aJD, item.getPrice());
                if (item.xM().equals(this.fef)) {
                    c0537b.fBW.setBackgroundResource(a.f.choose_gift_chosen_bg);
                } else {
                    c0537b.fBW.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_transparent));
                }
            }
            return view;
        }

        private void a(TextView textView, String str) {
            String formatGiftNumForTDouDisPlay;
            double d = JavaTypesHelper.toDouble(String.valueOf(str), 0.0d);
            if (d >= 100.0d && com.baidu.live.v.a.Hm().aZp.aAk) {
                formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
            } else {
                formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(str));
            }
            textView.setText(String.format(this.mContext.getResources().getString(a.i.sdk_choose_tdou_suffix), formatGiftNumForTDouDisPlay));
        }
    }

    /* renamed from: com.baidu.tieba.ala.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0537b {
        public TextView aJD;
        public FrameLayout fBW;
        public TbImageView fBX;
        public TextView fBY;

        private C0537b() {
        }
    }
}
