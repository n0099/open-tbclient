package com.baidu.tieba.ala;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.d.n;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class i extends BaseAdapter {
    private ArrayList<o> eXu = new ArrayList<>();
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<o> list) {
        if (list != null) {
            this.eXu.clear();
            this.eXu.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eXu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eXu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((o) getItem(i)).bUD();
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        a aVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            switch (itemViewType) {
                case 0:
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_wish_list_empty_item_layout, (ViewGroup) null);
                    a aVar2 = new a(view);
                    view.setTag(aVar2);
                    bVar = null;
                    aVar = aVar2;
                    break;
                case 1:
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_wish_list_item_layout, (ViewGroup) null);
                    b bVar2 = new b(view);
                    view.setTag(bVar2);
                    bVar = bVar2;
                    aVar = null;
                    break;
                default:
                    bVar = null;
                    aVar = null;
                    break;
            }
        } else {
            switch (itemViewType) {
                case 0:
                    bVar = null;
                    aVar = (a) view.getTag();
                    break;
                case 1:
                    bVar = (b) view.getTag();
                    aVar = null;
                    break;
                default:
                    bVar = null;
                    aVar = null;
                    break;
            }
        }
        final o oVar = (o) getItem(i);
        if (oVar != null) {
            switch (oVar.bUD()) {
                case 0:
                    if (aVar != null && aVar.rootView != null) {
                        aVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.i.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(i.this.mPageContext.getPageActivity(), 1002, i.this.getCount())));
                            }
                        });
                        break;
                    }
                    break;
                case 1:
                    if (bVar != null) {
                        bVar.bbs.setText(oVar.getmName());
                        bVar.gsU.setText(oVar.bUE() + "个");
                        bVar.gsV.setText(oVar.bUG() + "小时");
                        String string = this.mPageContext.getResources().getString(a.h.add_wish_thank_way_txt);
                        if (!TextUtils.isEmpty(oVar.bUH())) {
                            string = oVar.bUH();
                        }
                        bVar.gsW.setText(string);
                        bVar.gsX.startLoad(oVar.bUF(), 10, false);
                        if (oVar.bUD() == 1) {
                            if (getItemId(i) == 0) {
                                bVar.gsZ.setImageResource(a.e.ala_wish_list_item_num_icon_no1);
                            } else if (getItemId(i) == 1) {
                                bVar.gsZ.setImageResource(a.e.ala_wish_list_item_num_icon_no2);
                            } else if (getItemId(i) == 2) {
                                bVar.gsZ.setImageResource(a.e.ala_wish_list_item_num_icon_no3);
                            }
                        }
                        if (bVar != null && bVar.rootView != null) {
                            bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.i.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                }
                            });
                        }
                        bVar.gsY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.i.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.f(i.this.mPageContext.getPageActivity(), oVar.bUI(), 1001, i.this.getItemId(i))));
                            }
                        });
                        break;
                    }
                    break;
            }
        }
        return view;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public View rootView;

        public a(View view) {
            this.rootView = view;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public TextView bbs;
        public TextView gsU;
        public TextView gsV;
        public TextView gsW;
        public TbImageView gsX;
        public TbImageView gsY;
        public TbImageView gsZ;
        public View rootView;

        public b(View view) {
            this.rootView = view;
            this.bbs = (TextView) view.findViewById(a.f.ala_wish_list_item_center_content_first_name);
            this.gsU = (TextView) view.findViewById(a.f.ala_wish_list_item_center_content_first_num);
            this.gsV = (TextView) view.findViewById(a.f.ala_wish_list_item_center_content_deadline_num);
            this.gsW = (TextView) view.findViewById(a.f.ala_wish_list_item_center_content_thank_way);
            this.gsX = (TbImageView) view.findViewById(a.f.ala_wish_list_item_icon);
            this.gsX.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.gsY = (TbImageView) view.findViewById(a.f.ala_wish_list_item_top_delete);
            this.gsZ = (TbImageView) view.findViewById(a.f.ala_wish_list_item_num_icon);
        }
    }
}
