package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ChannelAddVideoActivity eHR;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.eHR = channelAddVideoActivity;
    }

    public List<com.baidu.tieba.channel.data.b> getData() {
        return this.mData;
    }

    public void setData(List<com.baidu.tieba.channel.data.b> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pM */
    public com.baidu.tieba.channel.data.b getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0297a c0297a;
        if (view != null) {
            c0297a = (C0297a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eHR.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_item_layout, viewGroup, false);
            C0297a c0297a2 = new C0297a();
            c0297a2.eHS = (TbCheckBox) view.findViewById(R.id.item_check_box);
            c0297a2.eHT = (TbImageView) view.findViewById(R.id.video_cover);
            c0297a2.eHU = (TextView) view.findViewById(R.id.video_length);
            c0297a2.title = (TextView) view.findViewById(R.id.title);
            c0297a2.eHV = (TextView) view.findViewById(R.id.forum_from);
            c0297a2.eHW = (TextView) view.findViewById(R.id.intro);
            view.setTag(c0297a2);
            c0297a = c0297a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0297a.eHS.setTagData(item);
            if (item.baK() == 1) {
                c0297a.eHS.setEnabled(false);
                am.c(c0297a.eHS, (int) R.drawable.icon_choose_channel_n);
            } else {
                c0297a.eHS.setEnabled(true);
                c0297a.eHS.akN();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0297a.eHT.setTag(null);
                c0297a.eHT.startLoad(item.getThumbnailUrl(), 10, false);
                c0297a.eHT.invalidate();
            }
            c0297a.eHU.setText(aq.io(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0297a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0297a.eHV.setText(item.getForumName() + "吧");
            }
            c0297a.eHW.setText(aq.aH(item.baJ()) + "次播放·" + com.baidu.tieba.channel.c.c.cG(item.getCreateTime()));
        }
        this.eHR.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eHR.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).baK() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0297a {
        public TbCheckBox eHS;
        public TbImageView eHT;
        public TextView eHU;
        public TextView eHV;
        public TextView eHW;
        public TextView title;

        public C0297a() {
        }
    }
}
