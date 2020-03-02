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
/* loaded from: classes3.dex */
public class g {
    private bj ejJ;
    private String enQ;
    private i erj;
    private boolean etJ;
    private a eum;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.ejJ != null && g.this.ejJ.aCH() != null && g.this.erj != null) {
                    g.this.erj.a(g.this.tabId, g.this.enQ, g.this.ejJ);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener etK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.ejJ != null && g.this.ejJ.aCo() != null && !StringUtils.isNull(g.this.ejJ.aCo().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.ejJ.aCo().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.ejJ.aCo().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.eum = new a(this.mRootView);
        this.etJ = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.erj = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.ejJ == null || cVar.ejJ.aCH() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ejJ = cVar.ejJ;
        this.tabId = cVar.tabId;
        this.enQ = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.eum.etM.setDrawerType(0);
        this.eum.etM.setBorderSurroundContent(true);
        this.eum.etM.setDrawBorder(true);
        this.eum.etM.startLoad(this.ejJ.aCH().cover, 10, false);
        this.eum.etO.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ejJ.aCH().audience_count)));
        this.eum.etQ.setData(this.ejJ, false);
        this.eum.etR.setText(this.ejJ.getTitle());
        if (this.ejJ.aCo() != null) {
            String name_show = this.ejJ.aCo().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eum.ahO.setText(name_show);
        }
        String str = this.ejJ.aCH().label_name;
        if (this.etJ && !StringUtils.isNull(str)) {
            this.eum.etN.setText(str);
            this.eum.etN.setVisibility(0);
        } else {
            this.eum.etN.setVisibility(8);
        }
        if (cVar.ejK) {
            this.eum.etS.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.ejJ.aCH().distance / 1000.0d))));
            this.eum.etS.setVisibility(0);
        } else {
            this.eum.etS.setVisibility(8);
        }
        this.eum.ahO.setOnClickListener(this.etK);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eum.etP, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eum.etO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eum.ahO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eum.etR, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eum.etS, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView ahO;
        public TbImageView etM;
        public TextView etN;
        public TextView etO;
        public RelativeLayout etP;
        public ClickableHeaderImageView etQ;
        public TextView etR;
        public TextView etS;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.etM = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.etN = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.etO = (TextView) view.findViewById(R.id.tvLiveCount);
            this.etP = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.etQ = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahO = (TextView) view.findViewById(R.id.tvUserName);
            this.etR = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.etS = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.etM.setDefaultErrorResource(0);
            this.etM.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.etM.setDrawerType(0);
            this.etQ.setIsRound(true);
            this.etQ.setDrawBorder(true);
            this.etQ.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.etQ.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.etQ.setIsGod(false);
            this.etQ.setIsBigV(false);
            this.etQ.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etP.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.etP.setLayoutParams(layoutParams);
        }
    }
}
