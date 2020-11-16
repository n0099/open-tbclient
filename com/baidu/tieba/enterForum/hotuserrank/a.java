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
/* loaded from: classes21.dex */
public class a {
    private View iiV;
    private TextView ilE;
    private TextView ilF;
    private TextView ilG;
    private ImageView ilH;
    private ImageView ilI;
    private ImageView ilJ;
    private ImageView ilK;
    private ImageView ilL;
    private IrregularImageView ilM;
    private TextView ilN;
    private RelativeLayout ilO;
    private ImageView ilP;
    private TextView ilQ;
    private ImageOverlayView ilR;
    private ImageView ilS;
    private ImageView ilT;
    private String ilU;
    private com.baidu.tieba.enterForum.hotuserrank.a.a ilV;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iiV.getId() && a.this.ilV != null && a.this.ilV.imR != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.ilV.imR.getUserId(), a.this.ilV.imR.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    ar arVar = new ar("c13659");
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dR("resource_id", a.this.ilV.rankName);
                    arVar.dR("friend_uid", a.this.ilV.imR.rankNum);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13683");
                arVar2.dR("uid", a.this.ilV.imR.getUserId());
                arVar2.w("fid", a.this.mForumId);
                TiebaStatic.log(arVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.iiV = view.findViewById(R.id.top_container);
        this.iiV.setOnClickListener(this.mOnClickListener);
        this.ilE = (TextView) view.findViewById(R.id.rank_name);
        this.ilE.getPaint().setFakeBoldText(true);
        this.ilF = (TextView) view.findViewById(R.id.top_user_name);
        this.ilG = (TextView) view.findViewById(R.id.rank_data);
        this.ilH = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.ilI = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.ilJ = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.ilK = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.ilL = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.ilM = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.ilM.setErrorRes(R.drawable.pic_list_avatar);
        this.ilH.setImageDrawable(SvgManager.bqB().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.ilI.setImageDrawable(SvgManager.bqB().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.ilJ.setImageDrawable(SvgManager.bqB().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.ilK.setImageDrawable(SvgManager.bqB().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.ilL.setImageDrawable(SvgManager.bqB().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.ilN = (TextView) view.findViewById(R.id.text_compute_method);
        this.ilN.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.ilO = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.ilO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    ar arVar = new ar("c13671");
                    arVar.w("fid", a.this.mForumId);
                    TiebaStatic.log(arVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.ilU);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.ilP = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.ilQ = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.ilT = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.ilR = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.ilR.j(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.ilR.setStrokeStyle(1);
        this.ilR.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.ilR.setLoadImageType(12);
        this.ilS = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.ilV = aVar;
        if (aVar != null) {
            this.ilE.setText(aVar.rankName);
            if (aVar.imR != null) {
                String str = aVar.imQ;
                if (ae.getTextLengthWithEmoji(aVar.imQ) > 10) {
                    str = ae.subStringWithEmoji(aVar.imQ, 10) + StringHelper.STRING_MORE;
                }
                this.ilF.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.imS == 0) {
                this.ilG.setVisibility(8);
            } else {
                this.ilG.setVisibility(0);
                this.ilG.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), au.dr(aVar.imS * 1000)));
            }
            this.ilM.setImage(aVar.imT, fi(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.imU != null && !z && !TextUtils.isEmpty(aVar.imU.tieba_name)) {
                this.ilO.setVisibility(0);
                this.ilQ.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.imU.tieba_name));
                List<String> cJ = cJ(aVar.imU.user_rank);
                this.ilR.setData(cJ);
                cK(cJ);
                this.ilU = aVar.imU.tieba_name;
                if (this.mForumId > 0) {
                    ar arVar = new ar("c13670");
                    arVar.w("fid", this.mForumId);
                    TiebaStatic.log(arVar);
                    return;
                }
                return;
            }
            this.ilO.setVisibility(8);
        }
    }

    private List<String> cJ(List<User> list) {
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

    private void cK(List<String> list) {
        int count = y.getCount(list);
        if (count == 0) {
            this.ilT.setVisibility(8);
            return;
        }
        this.ilT.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilT.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.ilT.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.ilN, R.color.CAM_X0109);
            SvgManager.bqB().a(this.ilP, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bqB().a(this.ilT, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            WebPManager.a(this.ilS, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.ilQ, R.color.CAM_X0105);
            this.ilR.onChangeSkinType();
        }
    }

    public BdUniqueId fi(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
