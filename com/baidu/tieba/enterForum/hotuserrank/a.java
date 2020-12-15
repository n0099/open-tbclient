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
    private View itQ;
    private TextView iwA;
    private TextView iwB;
    private TextView iwC;
    private ImageView iwD;
    private ImageView iwE;
    private ImageView iwF;
    private ImageView iwG;
    private ImageView iwH;
    private IrregularImageView iwI;
    private TextView iwJ;
    private RelativeLayout iwK;
    private ImageView iwL;
    private TextView iwM;
    private ImageOverlayView iwN;
    private ImageView iwO;
    private ImageView iwP;
    private String iwQ;
    private com.baidu.tieba.enterForum.hotuserrank.a.a iwR;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.itQ.getId() && a.this.iwR != null && a.this.iwR.ixM != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.iwR.ixM.getUserId(), a.this.iwR.ixM.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    ar arVar = new ar("c13659");
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dY("resource_id", a.this.iwR.rankName);
                    arVar.dY("friend_uid", a.this.iwR.ixM.rankNum);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13683");
                arVar2.dY("uid", a.this.iwR.ixM.getUserId());
                arVar2.w("fid", a.this.mForumId);
                TiebaStatic.log(arVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.itQ = view.findViewById(R.id.top_container);
        this.itQ.setOnClickListener(this.mOnClickListener);
        this.iwA = (TextView) view.findViewById(R.id.rank_name);
        this.iwA.getPaint().setFakeBoldText(true);
        this.iwB = (TextView) view.findViewById(R.id.top_user_name);
        this.iwC = (TextView) view.findViewById(R.id.rank_data);
        this.iwD = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.iwE = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.iwF = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.iwG = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.iwH = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.iwI = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.iwI.setErrorRes(R.drawable.pic_list_avatar);
        this.iwD.setImageDrawable(SvgManager.btW().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.iwE.setImageDrawable(SvgManager.btW().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.iwF.setImageDrawable(SvgManager.btW().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.iwG.setImageDrawable(SvgManager.btW().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.iwH.setImageDrawable(SvgManager.btW().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.iwJ = (TextView) view.findViewById(R.id.text_compute_method);
        this.iwJ.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.iwK = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.iwK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    ar arVar = new ar("c13671");
                    arVar.w("fid", a.this.mForumId);
                    TiebaStatic.log(arVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.iwQ);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.iwL = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.iwM = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.iwP = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.iwN = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.iwN.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.iwN.setStrokeStyle(1);
        this.iwN.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.iwN.setLoadImageType(12);
        this.iwO = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iwR = aVar;
        if (aVar != null) {
            this.iwA.setText(aVar.rankName);
            if (aVar.ixM != null) {
                String str = aVar.ixL;
                if (ae.getTextLengthWithEmoji(aVar.ixL) > 10) {
                    str = ae.subStringWithEmoji(aVar.ixL, 10) + StringHelper.STRING_MORE;
                }
                this.iwB.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.ixN == 0) {
                this.iwC.setVisibility(8);
            } else {
                this.iwC.setVisibility(0);
                this.iwC.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), au.dQ(aVar.ixN * 1000)));
            }
            this.iwI.setImage(aVar.ixO, fO(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.ixP != null && !z && !TextUtils.isEmpty(aVar.ixP.tieba_name)) {
                this.iwK.setVisibility(0);
                this.iwM.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.ixP.tieba_name));
                List<String> cN = cN(aVar.ixP.user_rank);
                this.iwN.setData(cN);
                cO(cN);
                this.iwQ = aVar.ixP.tieba_name;
                if (this.mForumId > 0) {
                    ar arVar = new ar("c13670");
                    arVar.w("fid", this.mForumId);
                    TiebaStatic.log(arVar);
                    return;
                }
                return;
            }
            this.iwK.setVisibility(8);
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
            this.iwP.setVisibility(8);
            return;
        }
        this.iwP.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iwP.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.iwP.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iwJ, R.color.CAM_X0109);
            SvgManager.btW().a(this.iwL, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.btW().a(this.iwP, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            WebPManager.a(this.iwO, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.iwM, R.color.CAM_X0105);
            this.iwN.onChangeSkinType();
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
