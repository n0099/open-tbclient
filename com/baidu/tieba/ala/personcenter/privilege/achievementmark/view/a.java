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
    private View bKe;
    private TbPageContext<BaseFragmentActivity> ceu;
    private TextView dQY;
    private HeadImageView dyf;
    private BdListView eyR;
    private b eyS;
    private TextView eyT;
    private TbImageView eyU;
    private RelativeLayout eyV;
    private ImageView eyW;
    private LinearLayout eyX;
    private AlaNetRefreshView eyY;
    private RelativeLayout eyZ;
    private TextView eza;
    private InterfaceC0384a ezb;
    private List<AlaLiveMarkData> ezc = new ArrayList();
    private b.a ezd = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.ezb != null) {
                a.this.ezb.a(bVar);
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
        this.ceu = tbPageContext;
        this.ezb = interfaceC0384a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.ceu.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.dyf = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.eyT = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.eyU = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.eyZ = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.eyX = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.eza = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.eyW = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.dQY = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.bKe = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.eyR = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.eyS = new b(this.ceu, this.ezd);
        this.eyR.setAdapter((ListAdapter) this.eyS);
        this.eyV = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.eyR.setEmptyView(this.eyV);
        this.dyf.setIsRound(true);
        this.dyf.setDefaultBgResource(R.color.transparent);
        this.dyf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eyU.setDefaultBgResource(R.color.transparent);
        this.eyU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.eyT, (int) R.color.white_alpha70);
        am.setViewTextColor(this.eza, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dQY, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.eyW.setAlpha(0.4f);
            this.bKe.setBackgroundColor(this.ceu.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.eyW.setAlpha(1.0f);
        this.bKe.setBackgroundColor(this.ceu.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.eyS != null && list != null) {
            this.eyS.setData(list);
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
                format = String.format(this.ceu.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.ceu.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            S(currentPortrait, str, format);
            int dimension = (int) this.ceu.getResources().getDimension(R.dimen.ds32);
            if (this.ezc != null && this.ezc.size() > 0) {
                this.ezc.clear();
            }
            if (this.eyX != null) {
                this.eyX.removeAllViews();
                this.ezc = alaUserInfoData.live_mark_info_new;
                if (this.ezc != null) {
                    for (int i = 0; i < this.ezc.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.ceu.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.ezc.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.ceu.getResources().getDimension(R.dimen.ds12);
                        this.eyX.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        S(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.ceu.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.ezc != null && this.ezc.size() > 0) {
            this.ezc.clear();
        }
        if (this.eyX != null) {
            this.eyX.removeAllViews();
        }
    }

    private void S(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.dyf.startLoad(str, 25, false);
            com.baidu.adp.lib.f.c.fT().a(str, 25, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.eyU.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.eyU.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.dyf.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.eyU.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.eyT.setText(str3);
        } else {
            this.eyT.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.ceu != null) {
            if (this.eyY == null) {
                this.eyY = new AlaNetRefreshView(this.ceu.getPageActivity());
            }
            this.eyY.setImageResource(i);
            this.eyY.setNetFailTipText(this.ceu.getString(i2));
            this.eyY.onChangeSkinType();
            this.eyY.setIsShowRefreshButton(z);
            if (z) {
                this.eyY.setOnRefreshClickListener(onClickListener);
            }
            this.eyY.attachView(this.eyZ);
        }
    }

    public void aJm() {
        if (this.eyY != null) {
            this.eyY.dettachView(this.eyZ);
        }
    }
}
