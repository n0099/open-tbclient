package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
import android.view.View;
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
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.a.b> {
    private h dBa;
    private a dDk;
    private boolean dDl;
    View.OnClickListener dDm;
    private bh dur;
    private String dxP;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dDl = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.dur != null && c.this.dur.aiX() != null && c.this.dBa != null) {
                        c.this.dBa.a(c.this.tabId, c.this.dxP, c.this.dur);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.dDm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dur != null && c.this.dur.aiE() != null && !StringUtils.isNull(c.this.dur.aiE().getUserId())) {
                    long j = com.baidu.adp.lib.g.b.toLong(c.this.dur.aiE().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.dur.aiE().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.dDk = new a(getView());
        this.dDl = z;
    }

    public void c(h hVar) {
        this.dBa = hVar;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dDk.dDr, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.dDk.dDq, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dDk.Xm, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dDk.dDt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dDk.dDu, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.a.b bVar) {
        if (bVar == null || bVar.dur == null || bVar.dur.aiX() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.dur = bVar.dur;
        this.tabId = bVar.tabId;
        this.dxP = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        this.dDk.dDo.startLoad(this.dur.aiX().cover, 10, false);
        this.dDk.dDq.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.dur.aiX().audience_count)));
        this.dDk.dDs.setData(this.dur, false);
        this.dDk.dDt.setText(this.dur.getTitle());
        if (this.dur.aiE() != null) {
            String name_show = this.dur.aiE().getName_show();
            if (aa.getTextLengthWithEmoji(name_show) > 10) {
                name_show = aa.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.dDk.Xm.setText(name_show);
        }
        String str = this.dur.aiX().label_name;
        if (this.dDl && !StringUtils.isNull(str)) {
            this.dDk.dDp.setText(str);
            this.dDk.dDp.setVisibility(0);
        } else {
            this.dDk.dDp.setVisibility(8);
        }
        if (bVar.dus) {
            this.dDk.dDu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.dur.aiX().distance / 1000.0d))));
            this.dDk.dDu.setVisibility(0);
        } else {
            this.dDk.dDu.setVisibility(8);
        }
        this.dDk.Xm.setOnClickListener(this.dDm);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
            view.setOnClickListener(c.this.mOnClickListener);
            this.dDo.setDefaultErrorResource(0);
            this.dDo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.dDo.setDrawerType(0);
            this.dDs.setIsRound(true);
            this.dDs.setDrawBorder(true);
            this.dDs.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.dDs.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.dDs.setIsGod(false);
            this.dDs.setIsBigV(false);
            this.dDs.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dDr.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.dDr.setLayoutParams(layoutParams);
        }
    }
}
