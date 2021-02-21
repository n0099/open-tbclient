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
    private View iHu;
    private TextView iKe;
    private TextView iKf;
    private TextView iKg;
    private ImageView iKh;
    private ImageView iKi;
    private ImageView iKj;
    private ImageView iKk;
    private ImageView iKl;
    private IrregularImageView iKm;
    private TextView iKn;
    private RelativeLayout iKo;
    private ImageView iKp;
    private TextView iKq;
    private ImageOverlayView iKr;
    private ImageView iKs;
    private ImageView iKt;
    private com.baidu.tieba.enterForum.hotuserrank.a.a iKu;
    private final String mCategory;
    private final long mForumId;
    private String mModuleName;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iHu.getId() && a.this.iKu != null && a.this.iKu.iLp != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.iKu.iLp.getUserId(), a.this.iKu.iLp.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    ar arVar = new ar("c13659");
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dR("resource_id", a.this.iKu.rankName);
                    arVar.dR("friend_uid", a.this.iKu.iLp.rankNum);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13683");
                arVar2.dR("uid", a.this.iKu.iLp.getUserId());
                arVar2.v("fid", a.this.mForumId);
                TiebaStatic.log(arVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.iHu = view.findViewById(R.id.top_container);
        this.iHu.setOnClickListener(this.mOnClickListener);
        this.iKe = (TextView) view.findViewById(R.id.rank_name);
        this.iKe.getPaint().setFakeBoldText(true);
        this.iKf = (TextView) view.findViewById(R.id.top_user_name);
        this.iKg = (TextView) view.findViewById(R.id.rank_data);
        this.iKh = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.iKi = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.iKj = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.iKk = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.iKl = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.iKm = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.iKm.setErrorRes(R.drawable.pic_list_avatar);
        this.iKh.setImageDrawable(SvgManager.bsR().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.iKi.setImageDrawable(SvgManager.bsR().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.iKj.setImageDrawable(SvgManager.bsR().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.iKk.setImageDrawable(SvgManager.bsR().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.iKl.setImageDrawable(SvgManager.bsR().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.iKn = (TextView) view.findViewById(R.id.text_compute_method);
        this.iKn.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.iKo = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.iKo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
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
        this.iKp = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.iKq = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.iKt = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.iKr = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.iKr.l(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.iKr.setStrokeStyle(1);
        this.iKr.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.iKr.setLoadImageType(12);
        this.iKs = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iKu = aVar;
        if (aVar != null) {
            this.iKe.setText(aVar.rankName);
            if (aVar.iLp != null) {
                String str = aVar.iLo;
                if (ag.getTextLengthWithEmoji(aVar.iLo) > 10) {
                    str = ag.subStringWithEmoji(aVar.iLo, 10) + StringHelper.STRING_MORE;
                }
                this.iKf.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.iLq == 0) {
                this.iKg.setVisibility(8);
            } else {
                this.iKg.setVisibility(0);
                this.iKg.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), au.dW(aVar.iLq * 1000)));
            }
            this.iKm.setImage(aVar.iLr, gg(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.iLs != null && !z && !TextUtils.isEmpty(aVar.iLs.tieba_name)) {
                this.iKo.setVisibility(0);
                this.iKq.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.iLs.tieba_name));
                List<String> cP = cP(aVar.iLs.user_rank);
                this.iKr.setData(cP);
                cQ(cP);
                this.mModuleName = aVar.iLs.tieba_name;
                if (this.mForumId > 0) {
                    ar arVar = new ar("c13670");
                    arVar.v("fid", this.mForumId);
                    TiebaStatic.log(arVar);
                    return;
                }
                return;
            }
            this.iKo.setVisibility(8);
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
            this.iKt.setVisibility(8);
            return;
        }
        this.iKt.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iKt.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.iKt.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iKn, R.color.CAM_X0109);
            SvgManager.bsR().a(this.iKp, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bsR().a(this.iKt, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            WebPManager.a(this.iKs, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.iKq, R.color.CAM_X0105);
            this.iKr.onChangeSkinType();
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
