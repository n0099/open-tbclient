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
    private bj ejW;
    private String eod;
    private i erx;
    private boolean etW;
    private a euz;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.ejW != null && g.this.ejW.aCH() != null && g.this.erx != null) {
                    g.this.erx.a(g.this.tabId, g.this.eod, g.this.ejW);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener etX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.ejW != null && g.this.ejW.aCo() != null && !StringUtils.isNull(g.this.ejW.aCo().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.ejW.aCo().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.ejW.aCo().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.euz = new a(this.mRootView);
        this.etW = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.erx = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.ejW == null || cVar.ejW.aCH() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ejW = cVar.ejW;
        this.tabId = cVar.tabId;
        this.eod = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.euz.etZ.setDrawerType(0);
        this.euz.etZ.setBorderSurroundContent(true);
        this.euz.etZ.setDrawBorder(true);
        this.euz.etZ.startLoad(this.ejW.aCH().cover, 10, false);
        this.euz.eub.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ejW.aCH().audience_count)));
        this.euz.eud.setData(this.ejW, false);
        this.euz.eue.setText(this.ejW.getTitle());
        if (this.ejW.aCo() != null) {
            String name_show = this.ejW.aCo().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.euz.ahO.setText(name_show);
        }
        String str = this.ejW.aCH().label_name;
        if (this.etW && !StringUtils.isNull(str)) {
            this.euz.eua.setText(str);
            this.euz.eua.setVisibility(0);
        } else {
            this.euz.eua.setVisibility(8);
        }
        if (cVar.ejX) {
            this.euz.euf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, aq.numberUniformFormatExtra((long) (this.ejW.aCH().distance / 1000.0d))));
            this.euz.euf.setVisibility(0);
        } else {
            this.euz.euf.setVisibility(8);
        }
        this.euz.ahO.setOnClickListener(this.etX);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.euz.euc, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.euz.eub, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.euz.ahO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.euz.eue, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.euz.euf, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public TextView ahO;
        public TbImageView etZ;
        public TextView eua;
        public TextView eub;
        public RelativeLayout euc;
        public ClickableHeaderImageView eud;
        public TextView eue;
        public TextView euf;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.etZ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eua = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eub = (TextView) view.findViewById(R.id.tvLiveCount);
            this.euc = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eud = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahO = (TextView) view.findViewById(R.id.tvUserName);
            this.eue = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.euf = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.etZ.setDefaultErrorResource(0);
            this.etZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.etZ.setDrawerType(0);
            this.eud.setIsRound(true);
            this.eud.setDrawBorder(true);
            this.eud.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.eud.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.eud.setIsGod(false);
            this.eud.setIsBigV(false);
            this.eud.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.euc.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.euc.setLayoutParams(layoutParams);
        }
    }
}
