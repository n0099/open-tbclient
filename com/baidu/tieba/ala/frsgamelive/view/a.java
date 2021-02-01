package com.baidu.tieba.ala.frsgamelive.view;

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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.d;
import com.baidu.tieba.ala.h;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private static String gWr;
    private h gUX;
    private C0629a gWp;
    private String gWq;
    private cb gyA;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gJa = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gyA != null && a.this.gyA.bnQ() != null && !StringUtils.isNull(a.this.gyA.bnQ().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(a.this.gyA.bnQ().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                d.bOE().bOF();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, a.this.gyA.bnQ().isBigV())));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gWp = new C0629a(this.mRootView);
        getView().setOnClickListener(this);
        gWr = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(h hVar) {
        this.gUX = hVar;
    }

    public void a(cb cbVar) {
        if (cbVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gyA = cbVar;
        this.gWp.gJc.setDrawerType(0);
        this.gWp.gJc.setBorderSurroundContent(true);
        this.gWp.gJc.setDrawBorder(true);
        this.gWp.gJc.startLoad(this.gyA.boj().cover, 10, false);
        this.gWp.gJe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, au.numberUniformFormatExtra(this.gyA.boj().audience_count)));
        this.gWp.gJg.setData(this.gyA);
        this.gWp.gJg.setIsRound(true);
        this.gWp.gJg.setBorderSurroundContent(true);
        this.gWp.gJh.setText(this.gyA.getTitle());
        if (this.gyA.bnQ() != null) {
            String name_show = this.gyA.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gWp.aYx.setText(name_show);
        }
        this.gWp.gWu.setVisibility(0);
        this.gWp.gJd.setBackgroundResource(R.drawable.transparent_bg);
        this.gWp.gJd.setText(this.gyA.boj().label_name);
        this.gWp.gJd.setVisibility(0);
        if (this.gyA.bnQ() == null || this.gyA.bnQ().getAlaUserData() == null || au.isEmpty(this.gyA.bnQ().getAlaUserData().great_anchor_icon)) {
            this.gWp.gWt.setVisibility(8);
        } else {
            this.gWp.gWt.setVisibility(0);
            this.gWp.gWt.startLoad(this.gyA.bnQ().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gWp.aYx.setOnClickListener(this.gJa);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gyA != null && this.gyA.boj() != null) {
            if (this.gUX != null) {
                this.gUX.S(this.gyA);
            }
            d.bOE().bOF();
            TiebaStatic.log(new ar("c12116").v("obj_id", this.gyA.boj().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gWp.gJf, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gWp.gJd, R.color.CAM_X0111);
            ap.setViewTextColor(this.gWp.gJe, R.color.CAM_X0101);
            ap.setViewTextColor(this.gWp.aYx, R.color.CAM_X0109);
            ap.setViewTextColor(this.gWp.gJh, R.color.CAM_X0105);
            ap.setViewTextColor(this.gWp.gWv, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gWq = str;
    }

    /* renamed from: com.baidu.tieba.ala.frsgamelive.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0629a {
        public TextView aYx;
        public LinearLayout gJQ;
        public RelativeLayout gJY;
        public TbImageView gJc;
        public TextView gJd;
        public TextView gJe;
        public RelativeLayout gJf;
        public ClickableHeaderImageView gJg;
        public TextView gJh;
        public TbImageView gWt;
        public View gWu;
        public TextView gWv;
        private LinearLayout.LayoutParams gWw;
        private LinearLayout.LayoutParams gWx;
        public View rootView;

        public C0629a(View view) {
            this.rootView = view;
            this.gJc = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gJd = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gJe = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gJf = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gJg = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aYx = (TextView) view.findViewById(R.id.tvUserName);
            this.gJY = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.gJh = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gJQ = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gWt = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gWu = view.findViewById(R.id.living_logo);
            this.gWv = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gWv.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gWw = (LinearLayout.LayoutParams) this.gJh.getLayoutParams();
            this.gWx = (LinearLayout.LayoutParams) this.gJQ.getLayoutParams();
            this.gWt.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gJc.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJf.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gWx.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gWx.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gWw.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gWw.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gJh.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gJY.setVisibility(0);
            this.gJQ.setLayoutParams(this.gWx);
            this.gJh.setLayoutParams(this.gWw);
            this.gJf.setLayoutParams(layoutParams);
        }
    }
}
