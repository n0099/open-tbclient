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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class g {
    private h dBa;
    private a dDO;
    private boolean dDl;
    private bh dur;
    private String dxP;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.dur != null && g.this.dur.aiX() != null && g.this.dBa != null) {
                    g.this.dBa.a(g.this.tabId, g.this.dxP, g.this.dur);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener dDm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.dur != null && g.this.dur.aiE() != null && !StringUtils.isNull(g.this.dur.aiE().getUserId())) {
                long j = com.baidu.adp.lib.g.b.toLong(g.this.dur.aiE().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.dur.aiE().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.dDO = new a(this.mRootView);
        this.dDl = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(h hVar) {
        this.dBa = hVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        if (bVar == null || bVar.dur == null || bVar.dur.aiX() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.dur = bVar.dur;
        this.tabId = bVar.tabId;
        this.dxP = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        this.dDO.dDo.setDrawerType(0);
        this.dDO.dDo.setBorderSurroundContent(true);
        this.dDO.dDo.setDrawBorder(true);
        this.dDO.dDo.startLoad(this.dur.aiX().cover, 10, false);
        this.dDO.dDq.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.dur.aiX().audience_count)));
        this.dDO.dDs.setData(this.dur, false);
        this.dDO.dDt.setText(this.dur.getTitle());
        if (this.dur.aiE() != null) {
            String name_show = this.dur.aiE().getName_show();
            if (aa.getTextLengthWithEmoji(name_show) > 10) {
                name_show = aa.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.dDO.Xm.setText(name_show);
        }
        String str = this.dur.aiX().label_name;
        if (this.dDl && !StringUtils.isNull(str)) {
            this.dDO.dDp.setText(str);
            this.dDO.dDp.setVisibility(0);
        } else {
            this.dDO.dDp.setVisibility(8);
        }
        if (bVar.dus) {
            this.dDO.dDu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.dur.aiX().distance / 1000.0d))));
            this.dDO.dDu.setVisibility(0);
        } else {
            this.dDO.dDu.setVisibility(8);
        }
        this.dDO.Xm.setOnClickListener(this.dDm);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dDO.dDr, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.dDO.dDq, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dDO.Xm, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dDO.dDt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dDO.dDu, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public TextView Xm;
        public TbImageView dDo;
        public TextView dDp;
        public TextView dDq;
        public RelativeLayout dDr;
        public ClickableHeaderImageView dDs;
        public TextView dDt;
        public TextView dDu;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.dDo = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.dDp = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.dDq = (TextView) view.findViewById(R.id.tvLiveCount);
            this.dDr = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.dDs = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.Xm = (TextView) view.findViewById(R.id.tvUserName);
            this.dDt = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.dDu = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.dDo.setDefaultErrorResource(0);
            this.dDo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.dDo.setDrawerType(0);
            this.dDs.setIsRound(true);
            this.dDs.setDrawBorder(true);
            this.dDs.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.dDs.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.dDs.setIsGod(false);
            this.dDs.setIsBigV(false);
            this.dDs.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dDr.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.dDr.setLayoutParams(layoutParams);
        }
    }
}
