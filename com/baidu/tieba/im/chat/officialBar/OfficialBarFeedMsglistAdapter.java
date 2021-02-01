package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> ajo = new ArrayList<>();
    private c kCx;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes8.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.kCx = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ajo.clear();
            this.ajo.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.ajo != null && this.ajo.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ajo.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ajo == null) {
            return 0;
        }
        return this.ajo.size();
    }

    /* loaded from: classes8.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView jPo;
        private View kCA;
        private a kCB;
        private BarImageView kCz;

        b(View view) {
            super(view);
            this.kCz = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.jPo = (TextView) view.findViewById(R.id.official_bar_name);
            this.kCA = view.findViewById(R.id.official_bar_feed_red_dot);
            this.kCz.setShowOval(true);
            this.kCz.setPlaceHolder(2);
            this.kCz.setShowOuterBorder(false);
            this.kCz.setShowInnerBorder(true);
            this.kCz.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.kCB = (a) aVar;
            ap.setViewTextColor(this.jPo, R.color.CAM_X0105);
            ap.setBackgroundResource(this.kCA, R.drawable.icon_official_bar_red_dot);
            this.kCz.setStrokeColorResId(R.color.CAM_X0401);
            this.kCz.startLoad(this.kCB.cUR(), 10, false);
            if (au.getChineseAndEnglishLength(this.kCB.cPg()) <= 10) {
                this.jPo.setText(this.kCB.cPg());
            } else {
                this.jPo.setText(au.cutChineseAndEnglishWithSuffix(this.kCB.cPg(), 8, StringHelper.STRING_MORE));
            }
            this.kCz.setOnClickListener(this);
            if (this.kCB.getUnReadCount() > 0 && (this.kCB.cUS() <= 0 || System.currentTimeMillis() - this.kCB.cUS() < 864000000)) {
                this.kCA.setVisibility(0);
            } else {
                this.kCA.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.kCA.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.kCx != null) {
                OfficialBarFeedMsglistAdapter.this.kCx.a(view, this.kCB, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long cZf;
        private long groupId;
        private String kCy;
        private String kbI;
        private int unReadCount;
        private int userType;

        String cUR() {
            return this.kCy;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cPg() {
            return this.kbI;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Ms(String str) {
            this.kCy = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Mt(String str) {
            this.kbI = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cUS() {
            return this.cZf;
        }

        public void gP(long j) {
            this.cZf = j;
        }
    }
}
