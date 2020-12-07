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
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes22.dex */
public class a {
    private View itO;
    private TextView iwA;
    private ImageView iwB;
    private ImageView iwC;
    private ImageView iwD;
    private ImageView iwE;
    private ImageView iwF;
    private IrregularImageView iwG;
    private TextView iwH;
    private RelativeLayout iwI;
    private ImageView iwJ;
    private TextView iwK;
    private ImageOverlayView iwL;
    private ImageView iwM;
    private ImageView iwN;
    private String iwO;
    private com.baidu.tieba.enterForum.hotuserrank.a.a iwP;
    private TextView iwy;
    private TextView iwz;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.itO.getId() && a.this.iwP != null && a.this.iwP.ixK != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.iwP.ixK.getUserId(), a.this.iwP.ixK.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    ar arVar = new ar("c13659");
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dY("resource_id", a.this.iwP.rankName);
                    arVar.dY("friend_uid", a.this.iwP.ixK.rankNum);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13683");
                arVar2.dY("uid", a.this.iwP.ixK.getUserId());
                arVar2.w("fid", a.this.mForumId);
                TiebaStatic.log(arVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.itO = view.findViewById(R.id.top_container);
        this.itO.setOnClickListener(this.mOnClickListener);
        this.iwy = (TextView) view.findViewById(R.id.rank_name);
        this.iwy.getPaint().setFakeBoldText(true);
        this.iwz = (TextView) view.findViewById(R.id.top_user_name);
        this.iwA = (TextView) view.findViewById(R.id.rank_data);
        this.iwB = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.iwC = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.iwD = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.iwE = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.iwF = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.iwG = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.iwG.setErrorRes(R.drawable.pic_list_avatar);
        this.iwB.setImageDrawable(SvgManager.btW().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.iwC.setImageDrawable(SvgManager.btW().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.iwD.setImageDrawable(SvgManager.btW().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.iwE.setImageDrawable(SvgManager.btW().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.iwF.setImageDrawable(SvgManager.btW().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.iwH = (TextView) view.findViewById(R.id.text_compute_method);
        this.iwH.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.iwI = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.iwI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    ar arVar = new ar("c13671");
                    arVar.w("fid", a.this.mForumId);
                    TiebaStatic.log(arVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.iwO);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.iwJ = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.iwK = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.iwN = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.iwL = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.iwL.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.iwL.setStrokeStyle(1);
        this.iwL.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.iwL.setLoadImageType(12);
        this.iwM = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iwP = aVar;
        if (aVar != null) {
            this.iwy.setText(aVar.rankName);
            if (aVar.ixK != null) {
                String str = aVar.ixJ;
                if (ae.getTextLengthWithEmoji(aVar.ixJ) > 10) {
                    str = ae.subStringWithEmoji(aVar.ixJ, 10) + StringHelper.STRING_MORE;
                }
                this.iwz.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.ixL == 0) {
                this.iwA.setVisibility(8);
            } else {
                this.iwA.setVisibility(0);
                this.iwA.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), au.dQ(aVar.ixL * 1000)));
            }
            this.iwG.setImage(aVar.ixM, fO(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.ixN != null && !z && !TextUtils.isEmpty(aVar.ixN.tieba_name)) {
                this.iwI.setVisibility(0);
                this.iwK.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.ixN.tieba_name));
                List<String> cN = cN(aVar.ixN.user_rank);
                this.iwL.setData(cN);
                cO(cN);
                this.iwO = aVar.ixN.tieba_name;
                if (this.mForumId > 0) {
                    ar arVar = new ar("c13670");
                    arVar.w("fid", this.mForumId);
                    TiebaStatic.log(arVar);
                    return;
                }
                return;
            }
            this.iwI.setVisibility(8);
        }
    }

    private List<String> cN(List<User> list) {
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

    private void cO(List<String> list) {
        int count = y.getCount(list);
        if (count == 0) {
            this.iwN.setVisibility(8);
            return;
        }
        this.iwN.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iwN.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.iwN.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iwH, R.color.CAM_X0109);
            SvgManager.btW().a(this.iwJ, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.btW().a(this.iwN, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            WebPManager.a(this.iwM, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.iwK, R.color.CAM_X0105);
            this.iwL.onChangeSkinType();
        }
    }

    public BdUniqueId fO(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
