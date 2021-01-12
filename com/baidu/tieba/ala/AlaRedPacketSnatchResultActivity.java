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
import com.baidu.live.data.ak;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.i;
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.g.o;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private HeadImageView bhZ;
    private String bre;
    private FrameLayout cBm;
    private TextView eGI;
    private View glm;
    private LinearLayout gln;
    private TextView gng;
    private TextView gnh;
    private TextView gni;
    private BdListView gnj;
    private a gnk;
    private com.baidu.tieba.ala.data.e gnl;
    private com.baidu.tieba.ala.g.g gnm;
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;
    private CustomMessageListener aww = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private o gnn = new o() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.g.o
        public void b(com.baidu.tieba.ala.data.e eVar) {
            AlaRedPacketSnatchResultActivity.this.a(eVar);
        }

        @Override // com.baidu.tieba.ala.g.o
        public void w(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.h.sdk_net_fail_tip);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
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
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            setContentView(a.g.ala_red_packet_snatch_result_view);
            initView();
            this.gnm = new com.baidu.tieba.ala.g.g(getPageContext(), this.gnn);
            this.gnm.ax(this.mRedPacketId, this.mLiveId, this.bre);
            MessageManager.getInstance().registerListener(this.aww);
            me(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bre = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.glm = findViewById(a.f.rp_result_root_bg);
        this.glm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.f.rp_result_close_btn);
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
        this.cBm = (FrameLayout) findViewById(a.f.rp_result_root_container);
        this.bhZ = (HeadImageView) findViewById(a.f.rp_result_user_icon);
        this.bhZ.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bhZ.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bhZ.setIsRound(true);
        this.bhZ.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bhZ.setAutoChangeStyle(true);
        this.bhZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gng = (TextView) findViewById(a.f.p_result_top10_desc);
        this.eGI = (TextView) findViewById(a.f.p_result_user_name);
        this.gnh = (TextView) findViewById(a.f.p_result_loot_amount);
        this.gln = (LinearLayout) findViewById(a.f.rp_result_content);
        this.gni = (TextView) findViewById(a.f.p_result_send_gift);
        this.gnj = (BdListView) findViewById(a.f.p_result_listview);
        this.gni.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bNR();
            }
        });
        this.gln.setVisibility(8);
        this.gni.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNR() {
        ak akVar = new ak();
        akVar.aHr = -1;
        akVar.aHs = -1;
        akVar.aHu = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
    }

    public void a(com.baidu.tieba.ala.data.e eVar) {
        String str;
        this.gnl = eVar;
        this.gln.setVisibility(0);
        this.gni.setVisibility(0);
        if (!StringUtils.isNullObject(eVar.portrait)) {
            m.a(this.bhZ, eVar.portrait, true, false);
        }
        this.eGI.setText(eVar.userName);
        if (eVar.gPP) {
            String format = String.format(getPageContext().getResources().getString(a.h.snatch_red_packet_amount_desc), Long.valueOf(eVar.gPx));
            this.gni.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gln.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds184);
            this.gln.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.h.snatch_red_packet_failed_1);
            this.gni.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gln.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.gln.setLayoutParams(layoutParams2);
            str = string;
        }
        this.gnh.setText(str);
        R(eVar.gPQ);
    }

    private void R(ArrayList<e.a> arrayList) {
        this.gnk = new a(getPageContext().getPageActivity(), arrayList);
        this.gnj.setAdapter((ListAdapter) this.gnk);
        this.gnk.notifyDataSetChanged();
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        me(configuration.orientation == 2);
    }

    private void me(boolean z) {
        if (z) {
            i.ae(this.cBm);
            this.cBm.setScaleX(0.85f);
            this.cBm.setScaleY(0.85f);
            return;
        }
        i.af(this.cBm);
        this.cBm.setScaleX(1.0f);
        this.cBm.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gnm != null) {
            this.gnm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aww);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends BaseAdapter {
        private ArrayList<e.a> gnp;
        private Context mContext;

        public a(Context context, ArrayList<e.a> arrayList) {
            this.mContext = context;
            this.gnp = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.gnp != null) {
                return this.gnp.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: tg */
        public e.a getItem(int i) {
            if (this.gnp != null) {
                return this.gnp.get(i);
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
                view = LayoutInflater.from(this.mContext).inflate(a.g.ala_loot_user_item, viewGroup, false);
                bVar2.bWX = (HeadImageView) view.findViewById(a.f.rp_user_list_icon);
                bVar2.bWX.setIsRound(true);
                bVar2.bWX.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
                bVar2.bWX.setAutoChangeStyle(true);
                bVar2.bWX.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.gnq = (TextView) view.findViewById(a.f.rp_user_list_name);
                bVar2.gnr = (TextView) view.findViewById(a.f.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            e.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    m.a(bVar.bWX, item.portrait, true, false);
                }
                bVar.gnq.setText(item.userName);
                bVar.gnr.setText(String.format(this.mContext.getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(item.amount)));
            }
            return view;
        }
    }

    /* loaded from: classes10.dex */
    private static class b {
        public HeadImageView bWX;
        public TextView gnq;
        public TextView gnr;

        private b() {
        }
    }
}
