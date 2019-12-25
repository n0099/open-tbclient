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
import com.baidu.live.data.o;
import com.baidu.live.q.a;
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
    private static final int edM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds588);
    private static final int edN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds804);
    private static final int edO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
    private static final float edP = (float) ((1.0d * edM) / edN);
    private FrameLayout aWK;
    private HeadImageView anq;
    private String arr;
    private TextView bXt;
    private View ecs;
    private LinearLayout ect;
    private TextView edQ;
    private TextView edR;
    private TextView edS;
    private BdListView edT;
    private a edU;
    private com.baidu.tieba.ala.data.d edV;
    private com.baidu.tieba.ala.e.e edW;
    private CustomMessageListener edX = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private k edY = new k() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.e.k
        public void b(com.baidu.tieba.ala.data.d dVar) {
            AlaRedPacketSnatchResultActivity.this.a(dVar);
        }

        @Override // com.baidu.tieba.ala.e.k
        public void aa(int i, String str) {
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
        this.edW = new com.baidu.tieba.ala.e.e(getPageContext(), this.edY);
        this.edW.ad(this.mRedPacketId, this.mLiveId, this.arr);
        MessageManager.getInstance().registerListener(this.edX);
        hB(UtilHelper.getRealScreenOrientation(this) == 2);
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.arr = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.ecs = findViewById(a.g.rp_result_root_bg);
        this.ecs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
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
        this.aWK = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.anq = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.anq.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.anq.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.anq.setIsRound(true);
        this.anq.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.anq.setAutoChangeStyle(true);
        this.anq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.edQ = (TextView) findViewById(a.g.p_result_top10_desc);
        this.bXt = (TextView) findViewById(a.g.p_result_user_name);
        this.edR = (TextView) findViewById(a.g.p_result_loot_amount);
        this.ect = (LinearLayout) findViewById(a.g.rp_result_content);
        this.edS = (TextView) findViewById(a.g.p_result_send_gift);
        this.edT = (BdListView) findViewById(a.g.p_result_listview);
        this.edS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.aYW();
            }
        });
        this.ect.setVisibility(8);
        this.edS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYW() {
        o oVar = new o();
        oVar.Wo = -1;
        oVar.Wp = -1;
        oVar.Wr = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, oVar));
    }

    public void a(com.baidu.tieba.ala.data.d dVar) {
        String str;
        this.edV = dVar;
        this.ect.setVisibility(0);
        this.edS.setVisibility(0);
        if (!StringUtils.isNULL(dVar.portrait)) {
            com.baidu.live.utils.k.a(this.anq, dVar.portrait, true, false);
        }
        this.bXt.setText(dVar.userName);
        if (dVar.eui) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(dVar.etP));
            this.edS.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ect.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.ect.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.edS.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ect.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.ect.setLayoutParams(layoutParams2);
            str = string;
        }
        this.edR.setText(str);
        N(dVar.euj);
    }

    private void N(ArrayList<d.a> arrayList) {
        this.edU = new a(getPageContext().getPageActivity(), arrayList);
        this.edT.setAdapter((ListAdapter) this.edU);
        this.edU.notifyDataSetChanged();
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
        hB(configuration.orientation == 2);
    }

    private void hB(boolean z) {
        if (z) {
            h.Q(this.aWK);
            this.aWK.setScaleX(0.85f);
            this.aWK.setScaleY(0.85f);
            return;
        }
        h.R(this.aWK);
        this.aWK.setScaleX(1.0f);
        this.aWK.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.edW != null) {
            this.edW.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.edX);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private ArrayList<d.a> eea;
        private Context mContext;

        public a(Context context, ArrayList<d.a> arrayList) {
            this.mContext = context;
            this.eea = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eea != null) {
                return this.eea.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: oh */
        public d.a getItem(int i) {
            if (this.eea != null) {
                return this.eea.get(i);
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
                bVar2.eeb = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.eeb.setIsRound(true);
                bVar2.eeb.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.eeb.setAutoChangeStyle(true);
                bVar2.eeb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.nameTv = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.eec = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            d.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNULL(item.portrait)) {
                    com.baidu.live.utils.k.a(bVar.eeb, item.portrait, true, false);
                }
                bVar.nameTv.setText(item.userName);
                bVar.eec.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.euk)));
            }
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        public HeadImageView eeb;
        public TextView eec;
        public TextView nameTv;

        private b() {
        }
    }
}
