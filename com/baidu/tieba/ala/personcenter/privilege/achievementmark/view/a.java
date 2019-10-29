package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private View bKV;
    private TbPageContext<BaseFragmentActivity> cfl;
    private TextView dRP;
    private HeadImageView dyW;
    private BdListView ezI;
    private b ezJ;
    private TextView ezK;
    private TbImageView ezL;
    private RelativeLayout ezM;
    private ImageView ezN;
    private LinearLayout ezO;
    private AlaNetRefreshView ezP;
    private RelativeLayout ezQ;
    private TextView ezR;
    private InterfaceC0384a ezS;
    private List<AlaLiveMarkData> ezT = new ArrayList();
    private b.a ezU = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.ezS != null) {
                a.this.ezS.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0384a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0384a interfaceC0384a) {
        this.cfl = tbPageContext;
        this.ezS = interfaceC0384a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.cfl.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.dyW = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.ezK = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.ezL = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.ezQ = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.ezO = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.ezR = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.ezN = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.dRP = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.bKV = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.ezI = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.ezJ = new b(this.cfl, this.ezU);
        this.ezI.setAdapter((ListAdapter) this.ezJ);
        this.ezM = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.ezI.setEmptyView(this.ezM);
        this.dyW.setIsRound(true);
        this.dyW.setDefaultBgResource(R.color.transparent);
        this.dyW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ezL.setDefaultBgResource(R.color.transparent);
        this.ezL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.ezK, (int) R.color.white_alpha70);
        am.setViewTextColor(this.ezR, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dRP, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.ezN.setAlpha(0.4f);
            this.bKV.setBackgroundColor(this.cfl.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.ezN.setAlpha(1.0f);
        this.bKV.setBackgroundColor(this.cfl.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.ezJ != null && list != null) {
            this.ezJ.setData(list);
        }
        a(alaUserInfoData);
    }

    private void a(AlaUserInfoData alaUserInfoData) {
        String format;
        if (alaUserInfoData != null) {
            String str = alaUserInfoData.user_nickname;
            String str2 = alaUserInfoData.user_name;
            if (str == null) {
                str = str2 != null ? str2 : TbadkApplication.getCurrentAccountNameShow();
            }
            String currentPortrait = alaUserInfoData.portrait == null ? TbadkApplication.getCurrentPortrait() : alaUserInfoData.portrait;
            if (alaUserInfoData.mark_count == null) {
                format = String.format(this.cfl.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.cfl.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            S(currentPortrait, str, format);
            int dimension = (int) this.cfl.getResources().getDimension(R.dimen.ds32);
            if (this.ezT != null && this.ezT.size() > 0) {
                this.ezT.clear();
            }
            if (this.ezO != null) {
                this.ezO.removeAllViews();
                this.ezT = alaUserInfoData.live_mark_info_new;
                if (this.ezT != null) {
                    for (int i = 0; i < this.ezT.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.cfl.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.ezT.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.cfl.getResources().getDimension(R.dimen.ds12);
                        this.ezO.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        S(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.cfl.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.ezT != null && this.ezT.size() > 0) {
            this.ezT.clear();
        }
        if (this.ezO != null) {
            this.ezO.removeAllViews();
        }
    }

    private void S(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.dyW.startLoad(str, 25, false);
            com.baidu.adp.lib.f.c.fT().a(str, 25, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.ezL.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.ezL.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.dyW.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.ezL.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.ezK.setText(str3);
        } else {
            this.ezK.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.cfl != null) {
            if (this.ezP == null) {
                this.ezP = new AlaNetRefreshView(this.cfl.getPageActivity());
            }
            this.ezP.setImageResource(i);
            this.ezP.setNetFailTipText(this.cfl.getString(i2));
            this.ezP.onChangeSkinType();
            this.ezP.setIsShowRefreshButton(z);
            if (z) {
                this.ezP.setOnRefreshClickListener(onClickListener);
            }
            this.ezP.attachView(this.ezQ);
        }
    }

    public void aJo() {
        if (this.ezP != null) {
            this.ezP.dettachView(this.ezQ);
        }
    }
}
