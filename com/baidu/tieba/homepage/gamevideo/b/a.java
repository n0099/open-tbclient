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
/* loaded from: classes22.dex */
public class a {
    private TbPageContext eIc;
    private GameVideoGridView jAi;
    private com.baidu.tieba.homepage.gamevideo.a.b jAj;
    private InterfaceC0740a jAk;
    private BdUniqueId mBdUniqueId;
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.a.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.jAj != null && i < a.this.jAj.getCount() && a.this.jAj.getItem(i) != null && (a.this.jAj.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) a.this.jAj.getItem(i);
                if (aVar.enable == 1) {
                    a.this.jAj.BE(aVar.sub_class_id);
                    if (a.this.jAk != null) {
                        a.this.jAk.a(aVar);
                    }
                    a.this.cJW();
                    com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    TiebaStatic.log(new aq("c13485").al("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View mRootView;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.gamevideo.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0740a {
        void a(com.baidu.tieba.homepage.gamevideo.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eIc = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.jAi = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_full_gridview);
        this.jAj = new com.baidu.tieba.homepage.gamevideo.a.b(this.eIc, 101, this.mBdUniqueId);
        this.jAi.setNumColumns(4);
        this.jAi.setAdapter((ListAdapter) this.jAj);
        this.jAi.setOnItemClickListener(this.mOnItemClickListener);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_full_title);
        onChangeSkinType();
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        if (!y.isEmpty(list)) {
            this.jAj.setData(list);
            this.jAj.notifyDataSetChanged();
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

    public void bF(ViewGroup viewGroup) {
        if (viewGroup != null && this.mRootView != null) {
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            viewGroup.addView(this.mRootView);
            TiebaStatic.log("c13484");
        }
    }

    public void cJW() {
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void a(InterfaceC0740a interfaceC0740a) {
        this.jAk = interfaceC0740a;
    }

    public void onDestroy() {
        if (this.jAi != null) {
            this.jAi.onDestroy();
        }
    }
}
