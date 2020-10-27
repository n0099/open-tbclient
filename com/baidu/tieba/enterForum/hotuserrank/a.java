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
/* loaded from: classes22.dex */
public class a {
    private View icg;
    private TextView ieT;
    private TextView ieU;
    private TextView ieV;
    private ImageView ieW;
    private ImageView ieX;
    private ImageView ieY;
    private ImageView ieZ;
    private ImageView ifa;
    private IrregularImageView ifb;
    private TextView ifc;
    private RelativeLayout ifd;
    private ImageView ife;
    private TextView iff;
    private ImageOverlayView ifg;
    private ImageView ifh;
    private ImageView ifi;
    private String ifj;
    private com.baidu.tieba.enterForum.hotuserrank.a.a ifk;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.icg.getId() && a.this.ifk != null && a.this.ifk.igf != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.ifk.igf.getUserId(), a.this.ifk.igf.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    aq aqVar = new aq("c13659");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dR("resource_id", a.this.ifk.rankName);
                    aqVar.dR("friend_uid", a.this.ifk.igf.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13683");
                aqVar2.dR("uid", a.this.ifk.igf.getUserId());
                aqVar2.w("fid", a.this.mForumId);
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.icg = view.findViewById(R.id.top_container);
        this.icg.setOnClickListener(this.mOnClickListener);
        this.ieT = (TextView) view.findViewById(R.id.rank_name);
        this.ieT.getPaint().setFakeBoldText(true);
        this.ieU = (TextView) view.findViewById(R.id.top_user_name);
        this.ieV = (TextView) view.findViewById(R.id.rank_data);
        this.ieW = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.ieX = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.ieY = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.ieZ = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.ifa = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.ifb = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.ifb.setErrorRes(R.drawable.pic_list_avatar);
        this.ieW.setImageDrawable(SvgManager.boN().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.ieX.setImageDrawable(SvgManager.boN().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.ieY.setImageDrawable(SvgManager.boN().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.ieZ.setImageDrawable(SvgManager.boN().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.ifa.setImageDrawable(SvgManager.boN().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.ifc = (TextView) view.findViewById(R.id.text_compute_method);
        this.ifc.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.ifd = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.ifd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    aq aqVar = new aq("c13671");
                    aqVar.w("fid", a.this.mForumId);
                    TiebaStatic.log(aqVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.ifj);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.ife = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.iff = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.ifi = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.ifg = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.ifg.j(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.cp_mask_c_alpha50, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.ifg.setStrokeStyle(1);
        this.ifg.setFirstImageStrokeColor(R.color.cp_other_h);
        this.ifg.setLoadImageType(12);
        this.ifh = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.ifk = aVar;
        if (aVar != null) {
            this.ieT.setText(aVar.rankName);
            if (aVar.igf != null) {
                String str = aVar.ige;
                if (af.getTextLengthWithEmoji(aVar.ige) > 10) {
                    str = af.subStringWithEmoji(aVar.ige, 10) + StringHelper.STRING_MORE;
                }
                this.ieU.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.igg == 0) {
                this.ieV.setVisibility(8);
            } else {
                this.ieV.setVisibility(0);
                this.ieV.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), at.cV(aVar.igg * 1000)));
            }
            this.ifb.setImage(aVar.igh, fi(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.igi != null && !z && !TextUtils.isEmpty(aVar.igi.tieba_name)) {
                this.ifd.setVisibility(0);
                this.iff.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.igi.tieba_name));
                List<String> cB = cB(aVar.igi.user_rank);
                this.ifg.setData(cB);
                cC(cB);
                this.ifj = aVar.igi.tieba_name;
                if (this.mForumId > 0) {
                    aq aqVar = new aq("c13670");
                    aqVar.w("fid", this.mForumId);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            this.ifd.setVisibility(8);
        }
    }

    private List<String> cB(List<User> list) {
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

    private void cC(List<String> list) {
        int count = y.getCount(list);
        if (count == 0) {
            this.ifi.setVisibility(8);
            return;
        }
        this.ifi.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifi.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.ifi.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.ifc, R.color.cp_cont_d);
            SvgManager.boN().a(this.ife, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.boN().a(this.ifi, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.boN().a(this.ifh, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.iff, R.color.cp_cont_b);
            this.ifg.onChangeSkinType();
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
