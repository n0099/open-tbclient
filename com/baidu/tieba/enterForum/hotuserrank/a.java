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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes21.dex */
public class a {
    private View hAO;
    private ImageView hDA;
    private ImageView hDB;
    private ImageView hDC;
    private ImageView hDD;
    private IrregularImageView hDE;
    private TextView hDF;
    private RelativeLayout hDG;
    private ImageView hDH;
    private TextView hDI;
    private ImageOverlayView hDJ;
    private ImageView hDK;
    private ImageView hDL;
    private String hDM;
    private com.baidu.tieba.enterForum.hotuserrank.a.a hDN;
    private TextView hDw;
    private TextView hDx;
    private TextView hDy;
    private ImageView hDz;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.hAO.getId() && a.this.hDN != null && a.this.hDN.hEI != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.hDN.hEI.getUserId(), a.this.hDN.hEI.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    aq aqVar = new aq("c13659");
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dF("resource_id", a.this.hDN.rankName);
                    aqVar.dF("friend_uid", a.this.hDN.hEI.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13683");
                aqVar2.dF("uid", a.this.hDN.hEI.getUserId());
                aqVar2.u("fid", a.this.mForumId);
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.hAO = view.findViewById(R.id.top_container);
        this.hAO.setOnClickListener(this.mOnClickListener);
        this.hDw = (TextView) view.findViewById(R.id.rank_name);
        this.hDw.getPaint().setFakeBoldText(true);
        this.hDx = (TextView) view.findViewById(R.id.top_user_name);
        this.hDy = (TextView) view.findViewById(R.id.rank_data);
        this.hDz = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.hDA = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.hDB = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.hDC = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.hDD = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.hDE = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.hDE.setErrorRes(R.drawable.pic_list_avatar);
        this.hDz.setImageDrawable(SvgManager.bkl().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.hDA.setImageDrawable(SvgManager.bkl().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.hDB.setImageDrawable(SvgManager.bkl().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.hDC.setImageDrawable(SvgManager.bkl().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.hDD.setImageDrawable(SvgManager.bkl().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.hDF = (TextView) view.findViewById(R.id.text_compute_method);
        this.hDF.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.hDG = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.hDG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    aq aqVar = new aq("c13671");
                    aqVar.u("fid", a.this.mForumId);
                    TiebaStatic.log(aqVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.hDM);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.hDH = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.hDI = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.hDL = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.hDJ = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.hDJ.j(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.cp_mask_c_alpha50, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.hDJ.setStrokeStyle(1);
        this.hDJ.setFirstImageStrokeColor(R.color.cp_other_h);
        this.hDJ.setLoadImageType(12);
        this.hDK = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.hDN = aVar;
        if (aVar != null) {
            this.hDw.setText(aVar.rankName);
            if (aVar.hEI != null) {
                String str = aVar.hEH;
                if (af.getTextLengthWithEmoji(aVar.hEH) > 10) {
                    str = af.subStringWithEmoji(aVar.hEH, 10) + StringHelper.STRING_MORE;
                }
                this.hDx.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.hEJ == 0) {
                this.hDy.setVisibility(8);
            } else {
                this.hDy.setVisibility(0);
                this.hDy.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), at.cL(aVar.hEJ * 1000)));
            }
            this.hDE.setImage(aVar.hEK, fa(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.hEL != null && !z && !TextUtils.isEmpty(aVar.hEL.tieba_name)) {
                this.hDG.setVisibility(0);
                this.hDI.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.hEL.tieba_name));
                List<String> cp = cp(aVar.hEL.user_rank);
                this.hDJ.setData(cp);
                cq(cp);
                this.hDM = aVar.hEL.tieba_name;
                if (this.mForumId > 0) {
                    aq aqVar = new aq("c13670");
                    aqVar.u("fid", this.mForumId);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            this.hDG.setVisibility(8);
        }
    }

    private List<String> cp(List<User> list) {
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

    private void cq(List<String> list) {
        int count = y.getCount(list);
        if (count == 0) {
            this.hDL.setVisibility(8);
            return;
        }
        this.hDL.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDL.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.hDL.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.hDF, R.color.cp_cont_d);
            SvgManager.bkl().a(this.hDH, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bkl().a(this.hDL, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bkl().a(this.hDK, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.hDI, R.color.cp_cont_b);
            this.hDJ.onChangeSkinType();
        }
    }

    public BdUniqueId fa(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
