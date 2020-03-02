package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class i implements o {
    CreateGroupStepActivity hvQ;
    private int hvU;
    HeadImageView hwq;
    ImageView hwr;
    TextView hws;
    private com.baidu.adp.widget.ImageView.a hwt = null;
    private a hwu = null;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hvQ = null;
        this.mView = null;
        this.hwq = null;
        this.hwr = null;
        this.hws = null;
        this.hvQ = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.hwr = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.hwq = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.hws = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.hvU = i3;
    }

    public void bTi() {
        if (this.hwu != null) {
            this.hwu.cancel();
        }
        this.hwt = null;
        this.hwu = new a();
        this.hwu.execute(new Object[0]);
    }

    public ImageView bTj() {
        return this.hwr;
    }

    public TextView bTk() {
        return this.hws;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSS() {
        this.hwr.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bST() {
        this.hvQ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hvQ.getLayoutMode().onModeChanged(this.mView);
        this.hwq.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.m.getImage(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.hwq.setVisibility(0);
                i.this.hwt = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.hwt.drawImageTo(i.this.hwq);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hvQ.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bSV() {
        if (this.mIndex != this.hvU) {
            return this.hvQ.getPageContext().getString(R.string.next_step);
        }
        return this.hvQ.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSW() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSM() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSX() {
        return true;
    }
}
