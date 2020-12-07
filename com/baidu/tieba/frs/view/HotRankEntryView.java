package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import java.util.ArrayList;
import tbclient.HotUserRankEntry;
import tbclient.ShortUserInfo;
/* loaded from: classes22.dex */
public class HotRankEntryView extends RelativeLayout {
    private ImageView jCT;
    private TextView jCU;
    private boolean jcu;
    private ImageOverlayView jtk;
    private ImageView mArrow;
    private int mSkinType;

    public HotRankEntryView(Context context) {
        this(context, null);
    }

    public HotRankEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        init(context);
    }

    private void init(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.hot_rank_entry, (ViewGroup) this, true);
        this.jCT = (ImageView) findViewById(R.id.first_tag);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
        this.jtk = (ImageOverlayView) findViewById(R.id.image_group);
        this.jtk.k(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.jtk.setStrokeStyle(1);
        this.jtk.setLoadImageType(12);
        this.jCU = (TextView) findViewById(R.id.entry_describe);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.HotRankEntryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotUserRankActivityConfig(context)));
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(HotUserRankEntry hotUserRankEntry, boolean z) {
        if (hotUserRankEntry != null && hotUserRankEntry.hot_user != null && hotUserRankEntry.hot_user.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (ShortUserInfo shortUserInfo : hotUserRankEntry.hot_user) {
                if (shortUserInfo != null) {
                    arrayList.add(shortUserInfo.portrait);
                }
            }
            this.jtk.setData(arrayList);
            this.jcu = z;
            this.jCU.setText(!au.isEmpty(hotUserRankEntry.module_name) ? hotUserRankEntry.module_name : getResources().getString(R.string.hot_rank));
            ap.setBackgroundResource(this, z ? R.drawable.frs_red_list_entrance_bg_black : R.drawable.frs_red_list_entrance_bg_white);
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setBackgroundResource(this, this.jcu ? R.drawable.frs_red_list_entrance_bg_black : R.drawable.frs_red_list_entrance_bg_white);
            SvgManager.btW().a(this.jCT, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            this.jtk.onChangeSkinType();
            ap.setViewTextColor(this.jCU, R.color.CAM_X0101);
            WebPManager.a(this.mArrow, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }
}
