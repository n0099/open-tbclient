package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private View dph;
    private TbPageContext<BaseFragmentActivity> eWx;
    private HeadImageView gFk;
    private TextView hmT;
    private b idA;
    private TextView idB;
    private TbImageView idC;
    private RelativeLayout idD;
    private ImageView idE;
    private LinearLayout idF;
    private AlaNetRefreshView idG;
    private RelativeLayout idH;
    private TextView idI;
    private InterfaceC0695a idJ;
    private List<AlaLiveMarkData> idK = new ArrayList();
    private b.a idL = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.idJ != null) {
                a.this.idJ.a(bVar);
            }
        }
    };
    private BdListView idz;
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0695a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0695a interfaceC0695a) {
        this.eWx = tbPageContext;
        this.idJ = interfaceC0695a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eWx.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.gFk = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.idB = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.idC = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.idH = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.idF = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.idI = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.idE = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.hmT = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.dph = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.idz = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.idA = new b(this.eWx, this.idL);
        this.idz.setAdapter((ListAdapter) this.idA);
        this.idD = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.idz.setEmptyView(this.idD);
        this.gFk.setIsRound(true);
        this.gFk.setDefaultBgResource(R.color.transparent);
        this.gFk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.idC.setDefaultBgResource(R.color.transparent);
        this.idC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.mName, R.color.common_color_10310);
        ap.setViewTextColor(this.idB, R.color.white_alpha70);
        ap.setViewTextColor(this.idI, R.color.CAM_X0109);
        ap.setViewTextColor(this.hmT, R.color.CAM_X0106);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.idE.setAlpha(0.4f);
            this.dph.setBackgroundColor(this.eWx.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.idE.setAlpha(1.0f);
        this.dph.setBackgroundColor(this.eWx.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.idA != null && list != null) {
            this.idA.setData(list);
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
                format = String.format(this.eWx.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.eWx.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            aB(currentPortrait, str, format);
            int dimension = (int) this.eWx.getResources().getDimension(R.dimen.ds32);
            if (this.idK != null && this.idK.size() > 0) {
                this.idK.clear();
            }
            if (this.idF != null) {
                this.idF.removeAllViews();
                this.idK = alaUserInfoData.live_mark_info_new;
                if (this.idK != null) {
                    for (int i = 0; i < this.idK.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.eWx.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.idK.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.eWx.getResources().getDimension(R.dimen.ds12);
                        this.idF.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        aB(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.eWx.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.idK != null && this.idK.size() > 0) {
            this.idK.clear();
        }
        if (this.idF != null) {
            this.idF.removeAllViews();
        }
    }

    private void aB(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.gFk.startLoad(str, 25, false);
            d.mw().a(str, 25, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.idC.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.idC.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.gFk.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.idC.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.idB.setText(str3);
        } else {
            this.idB.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.eWx != null) {
            if (this.idG == null) {
                this.idG = new AlaNetRefreshView(this.eWx.getPageActivity());
            }
            this.idG.setImageResource(i);
            this.idG.setNetFailTipText(this.eWx.getString(i2));
            this.idG.onChangeSkinType();
            this.idG.setIsShowRefreshButton(z);
            if (z) {
                this.idG.setOnRefreshClickListener(onClickListener);
            }
            this.idG.attachView(this.idH);
        }
    }

    public void Xc() {
        if (this.idG != null) {
            this.idG.dettachView(this.idH);
        }
    }
}
