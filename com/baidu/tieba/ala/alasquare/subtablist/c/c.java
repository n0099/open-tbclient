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
    private h dBR;
    private a dEb;
    private boolean dEc;
    View.OnClickListener dEd;
    private bh dvi;
    private String dyG;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dEc = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.dvi != null && c.this.dvi.aiZ() != null && c.this.dBR != null) {
                        c.this.dBR.a(c.this.tabId, c.this.dyG, c.this.dvi);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.dEd = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dvi != null && c.this.dvi.aiG() != null && !StringUtils.isNull(c.this.dvi.aiG().getUserId())) {
                    long j = com.baidu.adp.lib.g.b.toLong(c.this.dvi.aiG().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.dvi.aiG().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.dEb = new a(getView());
        this.dEc = z;
    }

    public void c(h hVar) {
        this.dBR = hVar;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dEb.dEi, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.dEb.dEh, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dEb.XE, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dEb.dEk, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dEb.dEl, (int) R.color.cp_cont_d);
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
        if (bVar == null || bVar.dvi == null || bVar.dvi.aiZ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.dvi = bVar.dvi;
        this.tabId = bVar.tabId;
        this.dyG = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        this.dEb.dEf.startLoad(this.dvi.aiZ().cover, 10, false);
        this.dEb.dEh.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.dvi.aiZ().audience_count)));
        this.dEb.dEj.setData(this.dvi, false);
        this.dEb.dEk.setText(this.dvi.getTitle());
        if (this.dvi.aiG() != null) {
            String name_show = this.dvi.aiG().getName_show();
            if (aa.getTextLengthWithEmoji(name_show) > 10) {
                name_show = aa.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.dEb.XE.setText(name_show);
        }
        String str = this.dvi.aiZ().label_name;
        if (this.dEc && !StringUtils.isNull(str)) {
            this.dEb.dEg.setText(str);
            this.dEb.dEg.setVisibility(0);
        } else {
            this.dEb.dEg.setVisibility(8);
        }
        if (bVar.dvj) {
            this.dEb.dEl.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.dvi.aiZ().distance / 1000.0d))));
            this.dEb.dEl.setVisibility(0);
        } else {
            this.dEb.dEl.setVisibility(8);
        }
        this.dEb.XE.setOnClickListener(this.dEd);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes6.dex */
    public class a {
        public TextView XE;
        public TbImageView dEf;
        public TextView dEg;
        public TextView dEh;
        public RelativeLayout dEi;
        public ClickableHeaderImageView dEj;
        public TextView dEk;
        public TextView dEl;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.dEf = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.dEg = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.dEh = (TextView) view.findViewById(R.id.tvLiveCount);
            this.dEi = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.dEj = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.XE = (TextView) view.findViewById(R.id.tvUserName);
            this.dEk = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.dEl = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(c.this.mOnClickListener);
            this.dEf.setDefaultErrorResource(0);
            this.dEf.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.dEf.setDrawerType(0);
            this.dEj.setIsRound(true);
            this.dEj.setDrawBorder(true);
            this.dEj.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.dEj.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.dEj.setIsGod(false);
            this.dEj.setIsBigV(false);
            this.dEj.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEi.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.dEi.setLayoutParams(layoutParams);
        }
    }
}
