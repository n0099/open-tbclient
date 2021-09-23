package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes7.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoPressedLinearLayout forumMemberTeamItemView;
    public HeadImageView headView1;
    public HeadImageView headView2;
    public HeadImageView headView3;
    public HeadImageView headView4;
    public TextView mTitleView;
    public LinearLayout memberView1;
    public LinearLayout memberView2;
    public LinearLayout memberView3;
    public LinearLayout memberView4;
    public TextView nameView1;
    public TextView nameView2;
    public TextView nameView3;
    public TextView nameView4;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMemberTeamViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int g2 = l.g(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = SkinManager.getColor(R.color.black_alpha10);
        TextView textView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView = textView;
        textView.setOnClickListener(onClickListener);
        this.memberView1 = (LinearLayout) view.findViewById(R.id.member1);
        this.headView1 = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.nameView1 = (TextView) view.findViewById(R.id.textview_user_name1);
        this.headView1.setIsRound(true);
        this.headView1.setBorderColor(color);
        this.headView1.setBorderWidth(g2);
        this.headView1.setOnClickListener(onClickListener);
        this.memberView2 = (LinearLayout) view.findViewById(R.id.member2);
        this.headView2 = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.nameView2 = (TextView) view.findViewById(R.id.textview_user_name2);
        this.headView2.setIsRound(true);
        this.headView2.setBorderColor(color);
        this.headView2.setBorderWidth(g2);
        this.headView2.setOnClickListener(onClickListener);
        this.memberView3 = (LinearLayout) view.findViewById(R.id.member3);
        this.headView3 = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.nameView3 = (TextView) view.findViewById(R.id.textview_user_name3);
        this.headView3.setIsRound(true);
        this.headView3.setBorderColor(color);
        this.headView3.setBorderWidth(g2);
        this.headView3.setOnClickListener(onClickListener);
        this.memberView4 = (LinearLayout) view.findViewById(R.id.member4);
        this.headView4 = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.nameView4 = (TextView) view.findViewById(R.id.textview_user_name4);
        this.headView4.setIsRound(true);
        this.headView4.setBorderColor(color);
        this.headView4.setBorderWidth(g2);
        this.headView4.setOnClickListener(onClickListener);
        this.forumMemberTeamItemView = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void fillMemberView(BawuRoleInfoPub bawuRoleInfoPub, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bawuRoleInfoPub, i2) == null) || bawuRoleInfoPub == null || i2 < 0 || i2 > 3) {
            return;
        }
        String str = bawuRoleInfoPub.portrait;
        if (i2 == 0) {
            this.headView1.startLoad(str, 12, false);
            this.headView1.setTag(bawuRoleInfoPub);
            this.headView1.setContentDescription(bawuRoleInfoPub.user_name);
            this.nameView1.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.memberView1.setVisibility(0);
        } else if (i2 == 1) {
            this.headView2.startLoad(str, 12, false);
            this.headView2.setTag(bawuRoleInfoPub);
            this.headView2.setContentDescription(bawuRoleInfoPub.user_name);
            this.nameView2.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.memberView2.setVisibility(0);
        } else if (i2 == 2) {
            this.headView3.startLoad(str, 12, false);
            this.headView3.setTag(bawuRoleInfoPub);
            this.headView3.setContentDescription(bawuRoleInfoPub.user_name);
            this.nameView3.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.memberView3.setVisibility(0);
        } else if (i2 != 3) {
        } else {
            this.headView4.startLoad(str, 12, false);
            this.headView4.setTag(bawuRoleInfoPub);
            this.headView4.setContentDescription(bawuRoleInfoPub.user_name);
            this.nameView4.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.memberView4.setVisibility(0);
        }
    }

    public void onChangeSkine(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.headView1.getVisibility() == 0) {
                this.headView1.setSkinType(i2);
                this.headView1.refresh();
            }
            if (this.headView2.getVisibility() == 0) {
                this.headView2.setSkinType(i2);
                this.headView2.refresh();
            }
            if (this.headView3.getVisibility() == 0) {
                this.headView3.setSkinType(i2);
                this.headView3.refresh();
            }
            if (this.headView4.getVisibility() == 0) {
                this.headView4.setSkinType(i2);
                this.headView4.refresh();
            }
        }
    }
}
