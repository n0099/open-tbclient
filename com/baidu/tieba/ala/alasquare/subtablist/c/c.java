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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.a.b> {
    private bj eft;
    private String eiR;
    private h elY;
    private a eoj;
    private boolean eok;
    View.OnClickListener eol;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eok = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.eft != null && c.this.eft.azX() != null && c.this.elY != null) {
                        c.this.elY.a(c.this.tabId, c.this.eiR, c.this.eft);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.eol = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eft != null && c.this.eft.azE() != null && !StringUtils.isNull(c.this.eft.azE().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.eft.azE().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.eft.azE().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.eoj = new a(getView());
        this.eok = z;
    }

    public void c(h hVar) {
        this.elY = hVar;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eoj.eoq, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eoj.eop, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eoj.aeX, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eoj.eos, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eoj.eot, (int) R.color.cp_cont_d);
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
        if (bVar == null || bVar.eft == null || bVar.eft.azX() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eft = bVar.eft;
        this.tabId = bVar.tabId;
        this.eiR = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        this.eoj.eon.startLoad(this.eft.azX().cover, 10, false);
        this.eoj.eop.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.eft.azX().audience_count)));
        this.eoj.eor.setData(this.eft, false);
        this.eoj.eos.setText(this.eft.getTitle());
        if (this.eft.azE() != null) {
            String name_show = this.eft.azE().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eoj.aeX.setText(name_show);
        }
        String str = this.eft.azX().label_name;
        if (this.eok && !StringUtils.isNull(str)) {
            this.eoj.eoo.setText(str);
            this.eoj.eoo.setVisibility(0);
        } else {
            this.eoj.eoo.setVisibility(8);
        }
        if (bVar.efu) {
            this.eoj.eot.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.eft.azX().distance / 1000.0d))));
            this.eoj.eot.setVisibility(0);
        } else {
            this.eoj.eot.setVisibility(8);
        }
        this.eoj.aeX.setOnClickListener(this.eol);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
            view.setOnClickListener(c.this.mOnClickListener);
            this.eon.setDefaultErrorResource(0);
            this.eon.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.eon.setDrawerType(0);
            this.eor.setIsRound(true);
            this.eor.setDrawBorder(true);
            this.eor.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.eor.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.eor.setIsGod(false);
            this.eor.setIsBigV(false);
            this.eor.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoq.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eoq.setLayoutParams(layoutParams);
        }
    }
}
