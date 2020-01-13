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
import com.baidu.live.data.q;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.d;
import com.baidu.tieba.ala.e.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private static final int edU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds588);
    private static final int edV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds804);
    private static final int edW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
    private static final float edX = (float) ((1.0d * edU) / edV);
    private FrameLayout aXC;
    private HeadImageView aod;
    private String asd;
    private TextView bXF;
    private View ecB;
    private LinearLayout ecC;
    private TextView edY;
    private TextView edZ;
    private TextView eea;
    private BdListView eeb;
    private a eec;
    private com.baidu.tieba.ala.data.d eed;
    private com.baidu.tieba.ala.e.e eee;
    private CustomMessageListener eef = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private k eeg = new k() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.e.k
        public void b(com.baidu.tieba.ala.data.d dVar) {
            AlaRedPacketSnatchResultActivity.this.a(dVar);
        }

        @Override // com.baidu.tieba.ala.e.k
        public void ac(int i, String str) {
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
        if (StringUtils.isNULL(this.mRedPacketId)) {
            finish();
            return;
        }
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme")) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
        }
        setContentView(a.h.ala_red_packet_snatch_result_view);
        initView();
        this.eee = new com.baidu.tieba.ala.e.e(getPageContext(), this.eeg);
        this.eee.ae(this.mRedPacketId, this.mLiveId, this.asd);
        MessageManager.getInstance().registerListener(this.eef);
        hG(UtilHelper.getRealScreenOrientation(this) == 2);
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.asd = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.ecB = findViewById(a.g.rp_result_root_bg);
        this.ecB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
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
        this.aXC = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.aod = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.aod.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aod.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aod.setIsRound(true);
        this.aod.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aod.setAutoChangeStyle(true);
        this.aod.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.edY = (TextView) findViewById(a.g.p_result_top10_desc);
        this.bXF = (TextView) findViewById(a.g.p_result_user_name);
        this.edZ = (TextView) findViewById(a.g.p_result_loot_amount);
        this.ecC = (LinearLayout) findViewById(a.g.rp_result_content);
        this.eea = (TextView) findViewById(a.g.p_result_send_gift);
        this.eeb = (BdListView) findViewById(a.g.p_result_listview);
        this.eea.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.aZq();
            }
        });
        this.ecC.setVisibility(8);
        this.eea.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZq() {
        q qVar = new q();
        qVar.WH = -1;
        qVar.WI = -1;
        qVar.WK = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, qVar));
    }

    public void a(com.baidu.tieba.ala.data.d dVar) {
        String str;
        this.eed = dVar;
        this.ecC.setVisibility(0);
        this.eea.setVisibility(0);
        if (!StringUtils.isNULL(dVar.portrait)) {
            com.baidu.live.utils.k.a(this.aod, dVar.portrait, true, false);
        }
        this.bXF.setText(dVar.userName);
        if (dVar.evt) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(dVar.eva));
            this.eea.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ecC.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.ecC.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.eea.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ecC.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.ecC.setLayoutParams(layoutParams2);
            str = string;
        }
        this.edZ.setText(str);
        N(dVar.evu);
    }

    private void N(ArrayList<d.a> arrayList) {
        this.eec = new a(getPageContext().getPageActivity(), arrayList);
        this.eeb.setAdapter((ListAdapter) this.eec);
        this.eec.notifyDataSetChanged();
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
        hG(configuration.orientation == 2);
    }

    private void hG(boolean z) {
        if (z) {
            h.S(this.aXC);
            this.aXC.setScaleX(0.85f);
            this.aXC.setScaleY(0.85f);
            return;
        }
        h.T(this.aXC);
        this.aXC.setScaleX(1.0f);
        this.aXC.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eee != null) {
            this.eee.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eef);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private ArrayList<d.a> eei;
        private Context mContext;

        public a(Context context, ArrayList<d.a> arrayList) {
            this.mContext = context;
            this.eei = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eei != null) {
                return this.eei.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: oh */
        public d.a getItem(int i) {
            if (this.eei != null) {
                return this.eei.get(i);
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
                bVar2.eej = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.eej.setIsRound(true);
                bVar2.eej.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.eej.setAutoChangeStyle(true);
                bVar2.eej.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.nameTv = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.eek = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            d.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNULL(item.portrait)) {
                    com.baidu.live.utils.k.a(bVar.eej, item.portrait, true, false);
                }
                bVar.nameTv.setText(item.userName);
                bVar.eek.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.evv)));
            }
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        public HeadImageView eej;
        public TextView eek;
        public TextView nameTv;

        private b() {
        }
    }
}
