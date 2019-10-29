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
    private h dBR;
    private a dEF;
    private boolean dEc;
    private bh dvi;
    private String dyG;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.dvi != null && g.this.dvi.aiZ() != null && g.this.dBR != null) {
                    g.this.dBR.a(g.this.tabId, g.this.dyG, g.this.dvi);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener dEd = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.dvi != null && g.this.dvi.aiG() != null && !StringUtils.isNull(g.this.dvi.aiG().getUserId())) {
                long j = com.baidu.adp.lib.g.b.toLong(g.this.dvi.aiG().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.dvi.aiG().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.dEF = new a(this.mRootView);
        this.dEc = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(h hVar) {
        this.dBR = hVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        if (bVar == null || bVar.dvi == null || bVar.dvi.aiZ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.dvi = bVar.dvi;
        this.tabId = bVar.tabId;
        this.dyG = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        this.dEF.dEf.setDrawerType(0);
        this.dEF.dEf.setBorderSurroundContent(true);
        this.dEF.dEf.setDrawBorder(true);
        this.dEF.dEf.startLoad(this.dvi.aiZ().cover, 10, false);
        this.dEF.dEh.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.dvi.aiZ().audience_count)));
        this.dEF.dEj.setData(this.dvi, false);
        this.dEF.dEk.setText(this.dvi.getTitle());
        if (this.dvi.aiG() != null) {
            String name_show = this.dvi.aiG().getName_show();
            if (aa.getTextLengthWithEmoji(name_show) > 10) {
                name_show = aa.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.dEF.XE.setText(name_show);
        }
        String str = this.dvi.aiZ().label_name;
        if (this.dEc && !StringUtils.isNull(str)) {
            this.dEF.dEg.setText(str);
            this.dEF.dEg.setVisibility(0);
        } else {
            this.dEF.dEg.setVisibility(8);
        }
        if (bVar.dvj) {
            this.dEF.dEl.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.dvi.aiZ().distance / 1000.0d))));
            this.dEF.dEl.setVisibility(0);
        } else {
            this.dEF.dEl.setVisibility(8);
        }
        this.dEF.XE.setOnClickListener(this.dEd);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dEF.dEi, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.dEF.dEh, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dEF.XE, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dEF.dEk, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dEF.dEl, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
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
            view.setOnClickListener(g.this.mOnClickListener);
            this.dEf.setDefaultErrorResource(0);
            this.dEf.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.dEf.setDrawerType(0);
            this.dEj.setIsRound(true);
            this.dEj.setDrawBorder(true);
            this.dEj.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.dEj.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.dEj.setIsGod(false);
            this.dEj.setIsBigV(false);
            this.dEj.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEi.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.dEi.setLayoutParams(layoutParams);
        }
    }
}
