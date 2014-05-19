package com.baidu.tieba.im.live.livelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    public h a;
    private BlackMembersListActivity b;
    private com.baidu.tbadk.editortool.ab d;
    private boolean e;
    private boolean g;
    private boolean f = true;
    private List<UserData> c = new ArrayList();

    public void a(h hVar) {
        this.a = hVar;
    }

    public boolean a() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean b() {
        return this.g;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public e(BlackMembersListActivity blackMembersListActivity) {
        this.b = blackMembersListActivity;
        this.d = new com.baidu.tbadk.editortool.ab(blackMembersListActivity);
        this.d.d(false);
    }

    public void a(List<UserData> list) {
        this.c.addAll(list);
    }

    public int c() {
        return this.c.size();
    }

    public boolean a(String str) {
        Iterator<UserData> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().getUserId().equals(str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (getItemId(i) != -1 && i >= 0 && i < this.c.size()) {
            return this.c.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.c.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) == -1 ? -1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == -1) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.s.live_list_foot, viewGroup, false);
            View findViewById = view.findViewById(com.baidu.tieba.r.bottom_line);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(com.baidu.tieba.r.bottom_more);
            TextView textView = (TextView) view.findViewById(com.baidu.tieba.r.more_title);
            ProgressBar progressBar = (ProgressBar) view.findViewById(com.baidu.tieba.r.more_progress);
            if (this.f) {
                findViewById.setVisibility(8);
                viewGroup2.setVisibility(8);
            } else {
                findViewById.setVisibility(8);
                viewGroup2.setVisibility(0);
                if (this.e) {
                    textView.setText(com.baidu.tieba.u.live_frs_list_hasmore);
                    progressBar.setVisibility(0);
                } else {
                    textView.setText(com.baidu.tieba.u.live_frs_list_nomore);
                    progressBar.setVisibility(8);
                }
            }
        } else {
            if (view == null) {
                view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.s.live_black_members_list_item, viewGroup, false);
                g gVar = new g(this);
                gVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.r.item_head);
                gVar.b = (TextView) view.findViewById(com.baidu.tieba.r.item_name);
                gVar.c = (ImageView) view.findViewById(com.baidu.tieba.r.item_sex);
                gVar.d = (Button) view.findViewById(com.baidu.tieba.r.item_unset);
                view.setTag(gVar);
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            g gVar2 = (g) view.getTag();
            Object item = getItem(i);
            if (item != null) {
                UserData userData = (UserData) item;
                gVar2.a.a(userData.getPortrait(), 12, false);
                gVar2.b.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        gVar2.c.setVisibility(0);
                        if (skinType == 1) {
                            gVar2.c.setImageResource(com.baidu.tieba.q.icon_pop_qz_boy_1);
                            break;
                        } else {
                            gVar2.c.setImageResource(com.baidu.tieba.q.icon_pop_qz_boy);
                            break;
                        }
                    case 2:
                        gVar2.c.setVisibility(0);
                        if (skinType == 1) {
                            gVar2.c.setImageResource(com.baidu.tieba.q.icon_pop_qz_girl_1);
                            break;
                        } else {
                            gVar2.c.setImageResource(com.baidu.tieba.q.icon_pop_qz_girl);
                            break;
                        }
                    default:
                        gVar2.c.setVisibility(8);
                        break;
                }
                gVar2.d.setVisibility(this.g ? 0 : 8);
                gVar2.d.setTag(userData);
                gVar2.d.setOnClickListener(new f(this));
            }
        }
        a(view);
        return view;
    }

    private void a(View view) {
        this.b.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.b.getLayoutMode().a(view);
    }
}
