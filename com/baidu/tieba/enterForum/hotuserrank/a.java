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
    private View gOh;
    private TextView gQR;
    private TextView gQS;
    private TextView gQT;
    private ImageView gQU;
    private ImageView gQV;
    private ImageView gQW;
    private ImageView gQX;
    private ImageView gQY;
    private IrregularImageView gQZ;
    private TextView gRa;
    private RelativeLayout gRb;
    private ImageView gRc;
    private TextView gRd;
    private ImageOverlayView gRe;
    private ImageView gRf;
    private ImageView gRg;
    private String gRh;
    private com.baidu.tieba.enterForum.hotuserrank.a.a gRi;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.gOh.getId() && a.this.gRi != null && a.this.gRi.gSf != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.gRi.gSf.getUserId(), a.this.gRi.gSf.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    an anVar = new an("c13659");
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.dh("resource_id", a.this.gRi.gSd);
                    anVar.dh("friend_uid", a.this.gRi.gSf.rankNum);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13683");
                anVar2.dh("uid", a.this.gRi.gSf.getUserId());
                anVar2.s("fid", a.this.mForumId);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.gOh = view.findViewById(R.id.top_container);
        this.gOh.setOnClickListener(this.mOnClickListener);
        this.gQR = (TextView) view.findViewById(R.id.rank_name);
        this.gQR.getPaint().setFakeBoldText(true);
        this.gQS = (TextView) view.findViewById(R.id.top_user_name);
        this.gQT = (TextView) view.findViewById(R.id.rank_data);
        this.gQU = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.gQV = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.gQW = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.gQX = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.gQY = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.gQZ = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.gQZ.setErrorRes(R.drawable.pic_list_avatar);
        this.gQU.setImageDrawable(SvgManager.aUV().i(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.gQV.setImageDrawable(SvgManager.aUV().i(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.gQW.setImageDrawable(SvgManager.aUV().i(R.drawable.svg_pic_mask_list_line, 1, false));
        this.gQX.setImageDrawable(SvgManager.aUV().i(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.gQY.setImageDrawable(SvgManager.aUV().i(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.gRa = (TextView) view.findViewById(R.id.text_compute_method);
        this.gRa.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.gRb = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.gRb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    an anVar = new an("c13671");
                    anVar.s("fid", a.this.mForumId);
                    TiebaStatic.log(anVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.gRh);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.gRc = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.gRd = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.gRg = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.gRe = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.gRe.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.cp_mask_c_alpha50, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.gRe.setStrokeStyle(1);
        this.gRe.setFirstImageStrokeColor(R.color.cp_other_h);
        this.gRe.setLoadImageType(12);
        this.gRf = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.gRi = aVar;
        if (aVar != null) {
            this.gQR.setText(aVar.gSd);
            if (aVar.gSf != null) {
                this.gQS.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), aq.ah(aVar.gSe, 10)));
            }
            if (aVar.gSg == 0) {
                this.gQT.setVisibility(8);
            } else {
                this.gQT.setVisibility(0);
                this.gQT.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), aq.ch(aVar.gSg * 1000)));
            }
            this.gQZ.setImage(aVar.gSh, eF(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.gSi != null && !z && !TextUtils.isEmpty(aVar.gSi.tieba_name)) {
                this.gRb.setVisibility(0);
                this.gRd.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.gSi.tieba_name));
                List<String> bT = bT(aVar.gSi.user_rank);
                this.gRe.setData(bT);
                bU(bT);
                this.gRh = aVar.gSi.tieba_name;
                if (this.mForumId > 0) {
                    an anVar = new an("c13670");
                    anVar.s("fid", this.mForumId);
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            this.gRb.setVisibility(8);
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
            this.gRg.setVisibility(8);
            return;
        }
        this.gRg.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRg.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.gRg.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.gRa, (int) R.color.cp_cont_d);
            SvgManager.aUV().a(this.gRc, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUV().a(this.gRg, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.aUV().a(this.gRf, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.gRd, (int) R.color.cp_cont_b);
            this.gRe.onChangeSkinType();
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
