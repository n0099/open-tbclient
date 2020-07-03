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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes9.dex */
public class a {
    private View hbf;
    private TextView hdL;
    private TextView hdM;
    private TextView hdN;
    private ImageView hdO;
    private ImageView hdP;
    private ImageView hdQ;
    private ImageView hdR;
    private ImageView hdS;
    private IrregularImageView hdT;
    private TextView hdU;
    private RelativeLayout hdV;
    private ImageView hdW;
    private TextView hdX;
    private ImageOverlayView hdY;
    private ImageView hdZ;
    private ImageView hea;
    private String heb;
    private com.baidu.tieba.enterForum.hotuserrank.a.a hec;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.hbf.getId() && a.this.hec != null && a.this.hec.heZ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.hec.heZ.getUserId(), a.this.hec.heZ.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    ao aoVar = new ao("c13659");
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    aoVar.dk("resource_id", a.this.hec.heX);
                    aoVar.dk("friend_uid", a.this.hec.heZ.rankNum);
                    TiebaStatic.log(aoVar);
                    return;
                }
                ao aoVar2 = new ao("c13683");
                aoVar2.dk("uid", a.this.hec.heZ.getUserId());
                aoVar2.s("fid", a.this.mForumId);
                TiebaStatic.log(aoVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.hbf = view.findViewById(R.id.top_container);
        this.hbf.setOnClickListener(this.mOnClickListener);
        this.hdL = (TextView) view.findViewById(R.id.rank_name);
        this.hdL.getPaint().setFakeBoldText(true);
        this.hdM = (TextView) view.findViewById(R.id.top_user_name);
        this.hdN = (TextView) view.findViewById(R.id.rank_data);
        this.hdO = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.hdP = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.hdQ = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.hdR = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.hdS = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.hdT = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.hdT.setErrorRes(R.drawable.pic_list_avatar);
        this.hdO.setImageDrawable(SvgManager.aWQ().i(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.hdP.setImageDrawable(SvgManager.aWQ().i(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.hdQ.setImageDrawable(SvgManager.aWQ().i(R.drawable.svg_pic_mask_list_line, 1, false));
        this.hdR.setImageDrawable(SvgManager.aWQ().i(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.hdS.setImageDrawable(SvgManager.aWQ().i(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.hdU = (TextView) view.findViewById(R.id.text_compute_method);
        this.hdU.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.hdV = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.hdV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    ao aoVar = new ao("c13671");
                    aoVar.s("fid", a.this.mForumId);
                    TiebaStatic.log(aoVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.heb);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.hdW = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.hdX = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.hea = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.hdY = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.hdY.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.cp_mask_c_alpha50, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.hdY.setStrokeStyle(1);
        this.hdY.setFirstImageStrokeColor(R.color.cp_other_h);
        this.hdY.setLoadImageType(12);
        this.hdZ = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.hec = aVar;
        if (aVar != null) {
            this.hdL.setText(aVar.heX);
            if (aVar.heZ != null) {
                String str = aVar.heY;
                if (ae.getTextLengthWithEmoji(aVar.heY) > 10) {
                    str = ae.subStringWithEmoji(aVar.heY, 10) + StringHelper.STRING_MORE;
                }
                this.hdM.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.hfa == 0) {
                this.hdN.setVisibility(8);
            } else {
                this.hdN.setVisibility(0);
                this.hdN.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), ar.ci(aVar.hfa * 1000)));
            }
            this.hdT.setImage(aVar.hfb, eG(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.hfc != null && !z && !TextUtils.isEmpty(aVar.hfc.tieba_name)) {
                this.hdV.setVisibility(0);
                this.hdX.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.hfc.tieba_name));
                List<String> cc = cc(aVar.hfc.user_rank);
                this.hdY.setData(cc);
                cd(cc);
                this.heb = aVar.hfc.tieba_name;
                if (this.mForumId > 0) {
                    ao aoVar = new ao("c13670");
                    aoVar.s("fid", this.mForumId);
                    TiebaStatic.log(aoVar);
                    return;
                }
                return;
            }
            this.hdV.setVisibility(8);
        }
    }

    private List<String> cc(List<User> list) {
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

    private void cd(List<String> list) {
        int count = w.getCount(list);
        if (count == 0) {
            this.hea.setVisibility(8);
            return;
        }
        this.hea.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hea.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.hea.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setViewTextColor(this.hdU, (int) R.color.cp_cont_d);
            SvgManager.aWQ().a(this.hdW, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.hea, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aWQ().a(this.hdZ, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
            an.setViewTextColor(this.hdX, (int) R.color.cp_cont_b);
            this.hdY.onChangeSkinType();
        }
    }

    public BdUniqueId eG(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
