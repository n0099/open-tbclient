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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes2.dex */
public class a {
    private View iHg;
    private TextView iJQ;
    private TextView iJR;
    private TextView iJS;
    private ImageView iJT;
    private ImageView iJU;
    private ImageView iJV;
    private ImageView iJW;
    private ImageView iJX;
    private IrregularImageView iJY;
    private TextView iJZ;
    private RelativeLayout iKa;
    private ImageView iKb;
    private TextView iKc;
    private ImageOverlayView iKd;
    private ImageView iKe;
    private ImageView iKf;
    private com.baidu.tieba.enterForum.hotuserrank.a.a iKg;
    private final String mCategory;
    private final long mForumId;
    private String mModuleName;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iHg.getId() && a.this.iKg != null && a.this.iKg.iLb != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.iKg.iLb.getUserId(), a.this.iKg.iLb.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    ar arVar = new ar("c13659");
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dR("resource_id", a.this.iKg.rankName);
                    arVar.dR("friend_uid", a.this.iKg.iLb.rankNum);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13683");
                arVar2.dR("uid", a.this.iKg.iLb.getUserId());
                arVar2.v("fid", a.this.mForumId);
                TiebaStatic.log(arVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.iHg = view.findViewById(R.id.top_container);
        this.iHg.setOnClickListener(this.mOnClickListener);
        this.iJQ = (TextView) view.findViewById(R.id.rank_name);
        this.iJQ.getPaint().setFakeBoldText(true);
        this.iJR = (TextView) view.findViewById(R.id.top_user_name);
        this.iJS = (TextView) view.findViewById(R.id.rank_data);
        this.iJT = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.iJU = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.iJV = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.iJW = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.iJX = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.iJY = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.iJY.setErrorRes(R.drawable.pic_list_avatar);
        this.iJT.setImageDrawable(SvgManager.bsR().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.iJU.setImageDrawable(SvgManager.bsR().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.iJV.setImageDrawable(SvgManager.bsR().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.iJW.setImageDrawable(SvgManager.bsR().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.iJX.setImageDrawable(SvgManager.bsR().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.iJZ = (TextView) view.findViewById(R.id.text_compute_method);
        this.iJZ.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.iKa = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.iKa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    ar arVar = new ar("c13671");
                    arVar.v("fid", a.this.mForumId);
                    TiebaStatic.log(arVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.mModuleName);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.iKb = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.iKc = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.iKf = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.iKd = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.iKd.l(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.iKd.setStrokeStyle(1);
        this.iKd.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.iKd.setLoadImageType(12);
        this.iKe = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iKg = aVar;
        if (aVar != null) {
            this.iJQ.setText(aVar.rankName);
            if (aVar.iLb != null) {
                String str = aVar.iLa;
                if (ag.getTextLengthWithEmoji(aVar.iLa) > 10) {
                    str = ag.subStringWithEmoji(aVar.iLa, 10) + StringHelper.STRING_MORE;
                }
                this.iJR.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.iLc == 0) {
                this.iJS.setVisibility(8);
            } else {
                this.iJS.setVisibility(0);
                this.iJS.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), au.dW(aVar.iLc * 1000)));
            }
            this.iJY.setImage(aVar.iLd, gg(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.iLe != null && !z && !TextUtils.isEmpty(aVar.iLe.tieba_name)) {
                this.iKa.setVisibility(0);
                this.iKc.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.iLe.tieba_name));
                List<String> cP = cP(aVar.iLe.user_rank);
                this.iKd.setData(cP);
                cQ(cP);
                this.mModuleName = aVar.iLe.tieba_name;
                if (this.mForumId > 0) {
                    ar arVar = new ar("c13670");
                    arVar.v("fid", this.mForumId);
                    TiebaStatic.log(arVar);
                    return;
                }
                return;
            }
            this.iKa.setVisibility(8);
        }
    }

    private List<String> cP(List<User> list) {
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

    private void cQ(List<String> list) {
        int count = y.getCount(list);
        if (count == 0) {
            this.iKf.setVisibility(8);
            return;
        }
        this.iKf.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iKf.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.iKf.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iJZ, R.color.CAM_X0109);
            SvgManager.bsR().a(this.iKb, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bsR().a(this.iKf, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            WebPManager.a(this.iKe, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.iKc, R.color.CAM_X0105);
            this.iKd.onChangeSkinType();
        }
    }

    public BdUniqueId gg(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
