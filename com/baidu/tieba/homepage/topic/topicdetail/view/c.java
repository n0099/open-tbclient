package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends m {
    private EditText fFy;

    public c(Context context) {
        super(context, (String) null, 29);
        this.fDI = false;
        this.fDH = 3;
        this.fCN = new TopicDetaiInputContainer(context);
        this.fFy = ((TopicDetaiInputContainer) this.fCN).getInputView();
        ((TopicDetaiInputContainer) this.fCN).setHint(context.getString(R.string.say_your_point));
        this.fDJ = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.fFy;
    }
}
