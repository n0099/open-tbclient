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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private TbPageContext efn;
    private GameVideoGridView iKe;
    private com.baidu.tieba.homepage.gamevideo.a.b iKf;
    private InterfaceC0695a iKg;
    private BdUniqueId mBdUniqueId;
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.a.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.iKf != null && i < a.this.iKf.getCount() && a.this.iKf.getItem(i) != null && (a.this.iKf.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) a.this.iKf.getItem(i);
                if (aVar.enable == 1) {
                    a.this.iKf.zR(aVar.sub_class_id);
                    if (a.this.iKg != null) {
                        a.this.iKg.a(aVar);
                    }
                    a.this.cwY();
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    TiebaStatic.log(new aq("c13485").ai("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View mRootView;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.gamevideo.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0695a {
        void a(com.baidu.tieba.homepage.gamevideo.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efn = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.iKe = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_full_gridview);
        this.iKf = new com.baidu.tieba.homepage.gamevideo.a.b(this.efn, 101, this.mBdUniqueId);
        this.iKe.setNumColumns(4);
        this.iKe.setAdapter((ListAdapter) this.iKf);
        this.iKe.setOnItemClickListener(this.mOnItemClickListener);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_full_title);
        onChangeSkinType();
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        if (!y.isEmpty(list)) {
            this.iKf.setData(list);
            this.iKf.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType() {
        if (this.mTitle != null) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        }
        if (this.mRootView != null) {
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
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

    public void cwY() {
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void a(InterfaceC0695a interfaceC0695a) {
        this.iKg = interfaceC0695a;
    }

    public void onDestroy() {
        if (this.iKe != null) {
            this.iKe.onDestroy();
        }
    }
}
