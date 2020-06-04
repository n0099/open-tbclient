package com.baidu.tieba.enterForum.hotuserrank;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes9.dex */
public class a {
    private View gOs;
    private TextView gRc;
    private TextView gRd;
    private TextView gRe;
    private ImageView gRf;
    private ImageView gRg;
    private ImageView gRh;
    private ImageView gRi;
    private ImageView gRj;
    private IrregularImageView gRk;
    private TextView gRl;
    private RelativeLayout gRm;
    private ImageView gRn;
    private TextView gRo;
    private ImageOverlayView gRp;
    private ImageView gRq;
    private ImageView gRr;
    private String gRs;
    private com.baidu.tieba.enterForum.hotuserrank.a.a gRt;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.gOs.getId() && a.this.gRt != null && a.this.gRt.gSq != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.gRt.gSq.getUserId(), a.this.gRt.gSq.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    an anVar = new an("c13659");
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.dh("resource_id", a.this.gRt.gSo);
                    anVar.dh("friend_uid", a.this.gRt.gSq.rankNum);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13683");
                anVar2.dh("uid", a.this.gRt.gSq.getUserId());
                anVar2.s("fid", a.this.mForumId);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.gOs = view.findViewById(R.id.top_container);
        this.gOs.setOnClickListener(this.mOnClickListener);
        this.gRc = (TextView) view.findViewById(R.id.rank_name);
        this.gRc.getPaint().setFakeBoldText(true);
        this.gRd = (TextView) view.findViewById(R.id.top_user_name);
        this.gRe = (TextView) view.findViewById(R.id.rank_data);
        this.gRf = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.gRg = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.gRh = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.gRi = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.gRj = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.gRk = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.gRk.setErrorRes(R.drawable.pic_list_avatar);
        this.gRf.setImageDrawable(SvgManager.aUW().i(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.gRg.setImageDrawable(SvgManager.aUW().i(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.gRh.setImageDrawable(SvgManager.aUW().i(R.drawable.svg_pic_mask_list_line, 1, false));
        this.gRi.setImageDrawable(SvgManager.aUW().i(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.gRj.setImageDrawable(SvgManager.aUW().i(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.gRl = (TextView) view.findViewById(R.id.text_compute_method);
        this.gRl.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.gRm = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.gRm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    an anVar = new an("c13671");
                    anVar.s("fid", a.this.mForumId);
                    TiebaStatic.log(anVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.gRs);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.gRn = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.gRo = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.gRr = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.gRp = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.gRp.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.cp_mask_c_alpha50, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.gRp.setStrokeStyle(1);
        this.gRp.setFirstImageStrokeColor(R.color.cp_other_h);
        this.gRp.setLoadImageType(12);
        this.gRq = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.gRt = aVar;
        if (aVar != null) {
            this.gRc.setText(aVar.gSo);
            if (aVar.gSq != null) {
                this.gRd.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), aq.ah(aVar.gSp, 10)));
            }
            if (aVar.gSr == 0) {
                this.gRe.setVisibility(8);
            } else {
                this.gRe.setVisibility(0);
                this.gRe.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), aq.ch(aVar.gSr * 1000)));
            }
            this.gRk.setImage(aVar.gSs, eF(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.gSt != null && !z && !TextUtils.isEmpty(aVar.gSt.tieba_name)) {
                this.gRm.setVisibility(0);
                this.gRo.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.gSt.tieba_name));
                List<String> bT = bT(aVar.gSt.user_rank);
                this.gRp.setData(bT);
                bU(bT);
                this.gRs = aVar.gSt.tieba_name;
                if (this.mForumId > 0) {
                    an anVar = new an("c13670");
                    anVar.s("fid", this.mForumId);
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            this.gRm.setVisibility(8);
        }
    }

    private List<String> bT(List<User> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (User user : list) {
            if (user != null) {
                arrayList.add(user.portrait);
            }
        }
        return arrayList;
    }

    private void bU(List<String> list) {
        int count = v.getCount(list);
        if (count == 0) {
            this.gRr.setVisibility(8);
            return;
        }
        this.gRr.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRr.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.gRr.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.gRl, (int) R.color.cp_cont_d);
            SvgManager.aUW().a(this.gRn, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUW().a(this.gRr, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUW().a(this.gRq, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.gRo, (int) R.color.cp_cont_b);
            this.gRp.onChangeSkinType();
        }
    }

    public BdUniqueId eF(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
