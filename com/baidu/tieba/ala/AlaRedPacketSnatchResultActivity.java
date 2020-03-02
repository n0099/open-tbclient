package com.baidu.tieba.ala;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.r;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.d;
import com.baidu.tieba.ala.e.k;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private static final int ehY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds588);
    private static final int ehZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds804);
    private static final int eia = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
    private static final float eib = (float) ((1.0d * ehY) / ehZ);
    private HeadImageView arv;
    private String awo;
    private FrameLayout bbO;
    private TextView cbK;
    private View egF;
    private LinearLayout egG;
    private TextView eic;
    private TextView eid;
    private TextView eie;
    private BdListView eif;
    private a eig;
    private com.baidu.tieba.ala.data.d eih;
    private com.baidu.tieba.ala.e.e eii;
    private CustomMessageListener eij = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private k eik = new k() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.e.k
        public void b(com.baidu.tieba.ala.data.d dVar) {
            AlaRedPacketSnatchResultActivity.this.a(dVar);
        }

        @Override // com.baidu.tieba.ala.e.k
        public void ad(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.i.sdk_net_fail_tip);
        }
    };
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        parserIntent();
        if (StringUtils.isNullObject(this.mRedPacketId)) {
            finish();
            return;
        }
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme")) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
        }
        setContentView(a.h.ala_red_packet_snatch_result_view);
        initView();
        this.eii = new com.baidu.tieba.ala.e.e(getPageContext(), this.eik);
        this.eii.ae(this.mRedPacketId, this.mLiveId, this.awo);
        MessageManager.getInstance().registerListener(this.eij);
        hN(UtilHelper.getRealScreenOrientation(this) == 2);
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.awo = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.egF = findViewById(a.g.rp_result_root_bg);
        this.egF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.g.rp_result_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.bbO = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.arv = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.arv.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.arv.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.arv.setIsRound(true);
        this.arv.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.arv.setAutoChangeStyle(true);
        this.arv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eic = (TextView) findViewById(a.g.p_result_top10_desc);
        this.cbK = (TextView) findViewById(a.g.p_result_user_name);
        this.eid = (TextView) findViewById(a.g.p_result_loot_amount);
        this.egG = (LinearLayout) findViewById(a.g.rp_result_content);
        this.eie = (TextView) findViewById(a.g.p_result_send_gift);
        this.eif = (BdListView) findViewById(a.g.p_result_listview);
        this.eie.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bbH();
            }
        });
        this.egG.setVisibility(8);
        this.eie.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbH() {
        r rVar = new r();
        rVar.Yt = -1;
        rVar.Yu = -1;
        rVar.Yw = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, rVar));
    }

    public void a(com.baidu.tieba.ala.data.d dVar) {
        String str;
        this.eih = dVar;
        this.egG.setVisibility(0);
        this.eie.setVisibility(0);
        if (!StringUtils.isNullObject(dVar.portrait)) {
            com.baidu.live.utils.k.a(this.arv, dVar.portrait, true, false);
        }
        this.cbK.setText(dVar.userName);
        if (dVar.ezF) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(dVar.ezn));
            this.eie.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.egG.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.egG.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.eie.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.egG.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.egG.setLayoutParams(layoutParams2);
            str = string;
        }
        this.eid.setText(str);
        P(dVar.ezG);
    }

    private void P(ArrayList<d.a> arrayList) {
        this.eig = new a(getPageContext().getPageActivity(), arrayList);
        this.eif.setAdapter((ListAdapter) this.eig);
        this.eig.notifyDataSetChanged();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hN(configuration.orientation == 2);
    }

    private void hN(boolean z) {
        if (z) {
            h.S(this.bbO);
            this.bbO.setScaleX(0.85f);
            this.bbO.setScaleY(0.85f);
            return;
        }
        h.T(this.bbO);
        this.bbO.setScaleX(1.0f);
        this.bbO.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eii != null) {
            this.eii.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eij);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BaseAdapter {
        private ArrayList<d.a> eim;
        private Context mContext;

        public a(Context context, ArrayList<d.a> arrayList) {
            this.mContext = context;
            this.eim = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eim != null) {
                return this.eim.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: oy */
        public d.a getItem(int i) {
            if (this.eim != null) {
                return this.eim.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_loot_user_item, viewGroup, false);
                bVar2.ein = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.ein.setIsRound(true);
                bVar2.ein.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.ein.setAutoChangeStyle(true);
                bVar2.ein.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.nameTv = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.eio = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            d.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    com.baidu.live.utils.k.a(bVar.ein, item.portrait, true, false);
                }
                bVar.nameTv.setText(item.userName);
                bVar.eio.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.ezH)));
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private static class b {
        public HeadImageView ein;
        public TextView eio;
        public TextView nameTv;

        private b() {
        }
    }
}
