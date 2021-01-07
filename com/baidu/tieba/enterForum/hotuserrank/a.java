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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes2.dex */
public class a {
    private View iGd;
    private TextView iIN;
    private TextView iIO;
    private TextView iIP;
    private ImageView iIQ;
    private ImageView iIR;
    private ImageView iIS;
    private ImageView iIT;
    private ImageView iIU;
    private IrregularImageView iIV;
    private TextView iIW;
    private RelativeLayout iIX;
    private ImageView iIY;
    private TextView iIZ;
    private ImageOverlayView iJa;
    private ImageView iJb;
    private ImageView iJc;
    private String iJd;
    private com.baidu.tieba.enterForum.hotuserrank.a.a iJe;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iGd.getId() && a.this.iJe != null && a.this.iJe.iJZ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.iJe.iJZ.getUserId(), a.this.iJe.iJZ.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    aq aqVar = new aq("c13659");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dX("resource_id", a.this.iJe.rankName);
                    aqVar.dX("friend_uid", a.this.iJe.iJZ.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13683");
                aqVar2.dX("uid", a.this.iJe.iJZ.getUserId());
                aqVar2.w("fid", a.this.mForumId);
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.iGd = view.findViewById(R.id.top_container);
        this.iGd.setOnClickListener(this.mOnClickListener);
        this.iIN = (TextView) view.findViewById(R.id.rank_name);
        this.iIN.getPaint().setFakeBoldText(true);
        this.iIO = (TextView) view.findViewById(R.id.top_user_name);
        this.iIP = (TextView) view.findViewById(R.id.rank_data);
        this.iIQ = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.iIR = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.iIS = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.iIT = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.iIU = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.iIV = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.iIV.setErrorRes(R.drawable.pic_list_avatar);
        this.iIQ.setImageDrawable(SvgManager.bwr().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.iIR.setImageDrawable(SvgManager.bwr().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.iIS.setImageDrawable(SvgManager.bwr().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.iIT.setImageDrawable(SvgManager.bwr().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.iIU.setImageDrawable(SvgManager.bwr().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.iIW = (TextView) view.findViewById(R.id.text_compute_method);
        this.iIW.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.iIX = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.iIX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    aq aqVar = new aq("c13671");
                    aqVar.w("fid", a.this.mForumId);
                    TiebaStatic.log(aqVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.iJd);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.iIY = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.iIZ = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.iJc = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.iJa = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.iJa.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.iJa.setStrokeStyle(1);
        this.iJa.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.iJa.setLoadImageType(12);
        this.iJb = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iJe = aVar;
        if (aVar != null) {
            this.iIN.setText(aVar.rankName);
            if (aVar.iJZ != null) {
                String str = aVar.iJY;
                if (ad.getTextLengthWithEmoji(aVar.iJY) > 10) {
                    str = ad.subStringWithEmoji(aVar.iJY, 10) + StringHelper.STRING_MORE;
                }
                this.iIO.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.iKa == 0) {
                this.iIP.setVisibility(8);
            } else {
                this.iIP.setVisibility(0);
                this.iIP.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), at.dQ(aVar.iKa * 1000)));
            }
            this.iIV.setImage(aVar.iKb, gh(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.iKc != null && !z && !TextUtils.isEmpty(aVar.iKc.tieba_name)) {
                this.iIX.setVisibility(0);
                this.iIZ.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.iKc.tieba_name));
                List<String> cU = cU(aVar.iKc.user_rank);
                this.iJa.setData(cU);
                cV(cU);
                this.iJd = aVar.iKc.tieba_name;
                if (this.mForumId > 0) {
                    aq aqVar = new aq("c13670");
                    aqVar.w("fid", this.mForumId);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            this.iIX.setVisibility(8);
        }
    }

    private List<String> cU(List<User> list) {
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

    private void cV(List<String> list) {
        int count = x.getCount(list);
        if (count == 0) {
            this.iJc.setVisibility(8);
            return;
        }
        this.iJc.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iJc.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.iJc.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.iIW, R.color.CAM_X0109);
            SvgManager.bwr().a(this.iIY, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bwr().a(this.iJc, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            WebPManager.a(this.iJb, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            ao.setViewTextColor(this.iIZ, R.color.CAM_X0105);
            this.iJa.onChangeSkinType();
        }
    }

    public BdUniqueId gh(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
