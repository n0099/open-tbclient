package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class g {
    private bj eft;
    private String eiR;
    private h elY;
    private a eoN;
    private boolean eok;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.eft != null && g.this.eft.azX() != null && g.this.elY != null) {
                    g.this.elY.a(g.this.tabId, g.this.eiR, g.this.eft);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener eol = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.eft != null && g.this.eft.azE() != null && !StringUtils.isNull(g.this.eft.azE().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.eft.azE().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.eft.azE().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.eoN = new a(this.mRootView);
        this.eok = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(h hVar) {
        this.elY = hVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        if (bVar == null || bVar.eft == null || bVar.eft.azX() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eft = bVar.eft;
        this.tabId = bVar.tabId;
        this.eiR = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        this.eoN.eon.setDrawerType(0);
        this.eoN.eon.setBorderSurroundContent(true);
        this.eoN.eon.setDrawBorder(true);
        this.eoN.eon.startLoad(this.eft.azX().cover, 10, false);
        this.eoN.eop.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.eft.azX().audience_count)));
        this.eoN.eor.setData(this.eft, false);
        this.eoN.eos.setText(this.eft.getTitle());
        if (this.eft.azE() != null) {
            String name_show = this.eft.azE().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eoN.aeX.setText(name_show);
        }
        String str = this.eft.azX().label_name;
        if (this.eok && !StringUtils.isNull(str)) {
            this.eoN.eoo.setText(str);
            this.eoN.eoo.setVisibility(0);
        } else {
            this.eoN.eoo.setVisibility(8);
        }
        if (bVar.efu) {
            this.eoN.eot.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.eft.azX().distance / 1000.0d))));
            this.eoN.eot.setVisibility(0);
        } else {
            this.eoN.eot.setVisibility(8);
        }
        this.eoN.aeX.setOnClickListener(this.eol);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eoN.eoq, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eoN.eop, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eoN.aeX, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eoN.eos, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eoN.eot, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView aeX;
        public TbImageView eon;
        public TextView eoo;
        public TextView eop;
        public RelativeLayout eoq;
        public ClickableHeaderImageView eor;
        public TextView eos;
        public TextView eot;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.eon = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eoo = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eop = (TextView) view.findViewById(R.id.tvLiveCount);
            this.eoq = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eor = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aeX = (TextView) view.findViewById(R.id.tvUserName);
            this.eos = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.eot = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.eon.setDefaultErrorResource(0);
            this.eon.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.eon.setDrawerType(0);
            this.eor.setIsRound(true);
            this.eor.setDrawBorder(true);
            this.eor.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.eor.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.eor.setIsGod(false);
            this.eor.setIsBigV(false);
            this.eor.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoq.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.eoq.setLayoutParams(layoutParams);
        }
    }
}
