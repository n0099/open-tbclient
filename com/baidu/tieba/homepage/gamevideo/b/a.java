package com.baidu.tieba.homepage.gamevideo.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private TbPageContext dPv;
    private GameVideoGridView ipJ;
    private com.baidu.tieba.homepage.gamevideo.a.b ipK;
    private InterfaceC0634a ipL;
    private BdUniqueId mBdUniqueId;
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.a.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.ipK != null && i < a.this.ipK.getCount() && a.this.ipK.getItem(i) != null && (a.this.ipK.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) a.this.ipK.getItem(i);
                if (aVar.enable == 1) {
                    a.this.ipK.xf(aVar.sub_class_id);
                    if (a.this.ipL != null) {
                        a.this.ipL.a(aVar);
                    }
                    a.this.ciN();
                    com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    TiebaStatic.log(new ao("c13485").ag("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View mRootView;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.gamevideo.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0634a {
        void a(com.baidu.tieba.homepage.gamevideo.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.dPv = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.ipJ = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_full_gridview);
        this.ipK = new com.baidu.tieba.homepage.gamevideo.a.b(this.dPv, 101, this.mBdUniqueId);
        this.ipJ.setNumColumns(4);
        this.ipJ.setAdapter((ListAdapter) this.ipK);
        this.ipJ.setOnItemClickListener(this.mOnItemClickListener);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_full_title);
        onChangeSkinType();
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        if (!w.isEmpty(list)) {
            this.ipK.setData(list);
            this.ipK.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType() {
        if (this.mTitle != null) {
            an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        }
        if (this.mRootView != null) {
            an.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        }
    }

    public void bA(ViewGroup viewGroup) {
        if (viewGroup != null && this.mRootView != null) {
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            viewGroup.addView(this.mRootView);
            TiebaStatic.log("c13484");
        }
    }

    public void ciN() {
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void a(InterfaceC0634a interfaceC0634a) {
        this.ipL = interfaceC0634a;
    }

    public void onDestroy() {
        if (this.ipJ != null) {
            this.ipJ.onDestroy();
        }
    }
}
