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
    private View iJd;
    private TextView iLN;
    private TextView iLO;
    private TextView iLP;
    private ImageView iLQ;
    private ImageView iLR;
    private ImageView iLS;
    private ImageView iLT;
    private ImageView iLU;
    private IrregularImageView iLV;
    private TextView iLW;
    private RelativeLayout iLX;
    private ImageView iLY;
    private TextView iLZ;
    private ImageOverlayView iMa;
    private ImageView iMb;
    private ImageView iMc;
    private com.baidu.tieba.enterForum.hotuserrank.a.a iMd;
    private final String mCategory;
    private final long mForumId;
    private String mModuleName;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iJd.getId() && a.this.iMd != null && a.this.iMd.iMY != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.iMd.iMY.getUserId(), a.this.iMd.iMY.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    ar arVar = new ar("c13659");
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dR("resource_id", a.this.iMd.rankName);
                    arVar.dR("friend_uid", a.this.iMd.iMY.rankNum);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13683");
                arVar2.dR("uid", a.this.iMd.iMY.getUserId());
                arVar2.v("fid", a.this.mForumId);
                TiebaStatic.log(arVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.iJd = view.findViewById(R.id.top_container);
        this.iJd.setOnClickListener(this.mOnClickListener);
        this.iLN = (TextView) view.findViewById(R.id.rank_name);
        this.iLN.getPaint().setFakeBoldText(true);
        this.iLO = (TextView) view.findViewById(R.id.top_user_name);
        this.iLP = (TextView) view.findViewById(R.id.rank_data);
        this.iLQ = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.iLR = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.iLS = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.iLT = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.iLU = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.iLV = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.iLV.setErrorRes(R.drawable.pic_list_avatar);
        this.iLQ.setImageDrawable(SvgManager.bsU().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.iLR.setImageDrawable(SvgManager.bsU().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.iLS.setImageDrawable(SvgManager.bsU().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.iLT.setImageDrawable(SvgManager.bsU().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.iLU.setImageDrawable(SvgManager.bsU().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.iLW = (TextView) view.findViewById(R.id.text_compute_method);
        this.iLW.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.iLX = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.iLX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
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
        this.iLY = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.iLZ = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.iMc = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.iMa = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.iMa.l(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.iMa.setStrokeStyle(1);
        this.iMa.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.iMa.setLoadImageType(12);
        this.iMb = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iMd = aVar;
        if (aVar != null) {
            this.iLN.setText(aVar.rankName);
            if (aVar.iMY != null) {
                String str = aVar.iMX;
                if (ag.getTextLengthWithEmoji(aVar.iMX) > 10) {
                    str = ag.subStringWithEmoji(aVar.iMX, 10) + StringHelper.STRING_MORE;
                }
                this.iLO.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.iMZ == 0) {
                this.iLP.setVisibility(8);
            } else {
                this.iLP.setVisibility(0);
                this.iLP.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), au.dW(aVar.iMZ * 1000)));
            }
            this.iLV.setImage(aVar.iNa, gf(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.iNb != null && !z && !TextUtils.isEmpty(aVar.iNb.tieba_name)) {
                this.iLX.setVisibility(0);
                this.iLZ.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.iNb.tieba_name));
                List<String> cP = cP(aVar.iNb.user_rank);
                this.iMa.setData(cP);
                cQ(cP);
                this.mModuleName = aVar.iNb.tieba_name;
                if (this.mForumId > 0) {
                    ar arVar = new ar("c13670");
                    arVar.v("fid", this.mForumId);
                    TiebaStatic.log(arVar);
                    return;
                }
                return;
            }
            this.iLX.setVisibility(8);
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
            this.iMc.setVisibility(8);
            return;
        }
        this.iMc.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iMc.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.iMc.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iLW, R.color.CAM_X0109);
            SvgManager.bsU().a(this.iLY, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bsU().a(this.iMc, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            WebPManager.a(this.iMb, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.iLZ, R.color.CAM_X0105);
            this.iMa.onChangeSkinType();
        }
    }

    public BdUniqueId gf(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
